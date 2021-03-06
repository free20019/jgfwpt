package mvc.service;

import cache.DataItem;
import cache.GisData;
import com.vividsolutions.jts.geom.Geometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import util.GeometryHandler;
import util.JacksonUtil;

import javax.servlet.ServletContextEvent;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class GisService {

	protected JdbcTemplate jdbcTemplate = null;
	protected JdbcTemplate jdbcTemplate2 = null;
	protected Thread thread;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate2() {
		return jdbcTemplate2;
	}

	@Autowired
	public void setJdbcTemplate2(JdbcTemplate jdbcTemplate2) {
		this.jdbcTemplate2 = jdbcTemplate2;
	}

	@Autowired
	private KeyAreaService keyAreaService;

	private JacksonUtil jacksonUtil = JacksonUtil.buildNormalBinder();
	private boolean exit_thread;

	public String test() {
		System.out.println(jdbcTemplate);
		System.out.println(jdbcTemplate2);

		return "ok";
	}

	public int timenum(String arg){
		return Integer.parseInt(arg.split(":")[0])*60+Integer.parseInt(arg.split(":")[1]);
	}

	public void stop(){
		exit_thread = true;
	}

	public String task() {
		exit_thread = false;
		thread = new Thread() {
			private List<Map<String, Object>> vehilist = new ArrayList<Map<String, Object>>();
			private Map<String, Object> num = new HashMap<String, Object>();
			private List<Map<String, Object>> arealist = new ArrayList<Map<String, Object>>();
			private List<Map<String, Object>> focuslist = new ArrayList<Map<String, Object>>();
			private List<Map<String, Object>> faultlist = new ArrayList<Map<String, Object>>();
			private long sleepTime = 300000;

			@Override
			public void run() {
				while (true && !exit_thread) {
					System.out.println("执行---------------");
					int onnum = 0;
					int offnum = 0;
					int hnum = 0;
					int nnum = 0;
					vehilist = keyAreaService.getVehicleMonitor();
					for (int i = 0; i < vehilist.size(); i++) {
						Map<String, Object> va = vehilist.get(i);
                        if (va.get("STIME") != null && !"".equals(String.valueOf(va.get("STIME")))&&jisuan(String.valueOf(va.get("STIME")))) {
                        	va.put("ONLINE","0");
                            onnum++;
                        } else {
							va.put("ONLINE","1");
                            offnum++;
                        }

                        if ("0".equals(String.valueOf(va.get("STATE")))) {
                            nnum++;
                        } else if ("1".equals(String.valueOf(va.get("STATE")))) {
                            hnum++;
                        }
					}
					int total = vehilist.size();
					num.put("total", total);
					num.put("online", onnum);
					num.put("notOnline", offnum);
					num.put("heavyCar", hnum);
					num.put("emptyCar", nnum);
					arealist = keyAreaService.getAreaMonitor();
					List<String> list= null;
					for(int j=0;j<vehilist.size();j++){
						for(int k=0;k<arealist.size();k++){
							if(rectContains(vehilist.get(j), arealist.get(k))){
								list= arealist.get(k).get("VEHILIST")==null?new ArrayList<String>(): (List<String>) arealist.get(k).get("VEHILIST");
								list.add(vehilist.get(j).get("VEHI_NO")+";"+vehilist.get(j).get("COMP_NAME"));
								arealist.get(k).put("VEHILIST",list);
								break;
							}
						}
					}

					DataItem data = (DataItem) GisData.map.get("data");
					if (null == data) {
						data = new DataItem();
						GisData.map.put("data", data);
					}
					Collections.sort(vehilist, new PointCompare2());
					try {
						// deletePoint2(vehilist,0.1);
					} catch (Exception e) {
						e.printStackTrace();
					}
					faultlist = keyAreaService.findFaultMonitor();
					focuslist = keyAreaService.findFocusMonitor();
					data.setArealist(arealist);
					data.setNum(num);
					data.setVehilist(vehilist);
					data.setFaultlist(faultlist);
					data.setFocuslist(focuslist);
					System.out.println("结束---------------");
					try {
						Thread.sleep(sleepTime );
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}


			public <T> List<T> deepCopy(List<T> src) throws IOException,
					ClassNotFoundException {
				ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
				ObjectOutputStream out = new ObjectOutputStream(byteOut);
				out.writeObject(src);

				ByteArrayInputStream byteIn = new ByteArrayInputStream(
						byteOut.toByteArray());
				ObjectInputStream in = new ObjectInputStream(byteIn);
				@SuppressWarnings("unchecked")
				List<T> dest = (List<T>) in.readObject();
				return dest;
			}
		};

		try {
			thread.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 计算车辆是否上线
	public static boolean jisuan(String date1) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		double result = 0;
		try {
			Date start = sdf.parse(date1);
			Date end = new Date();
			long cha = end.getTime() - start.getTime();
			result = cha * 1.0 / (1000 * 60);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (result <= 5) {
			return true;
		} else {
			return false;
		}
	}
	//车辆是否在区域内
	private boolean rectContains(Map<String, Object> vehicle, Map<String, Object> area) {
		if(area.get("AREA_COORDINATES")==null||vehicle.get("LONGI")==null||vehicle.get("LATI")==null){
			return false;
		}
		String[] zbs = (area.get("AREA_COORDINATES")==null?"":String.valueOf(area.get("AREA_COORDINATES"))).split(";");//120.123,30.123;123.123,33.211;
		Geometry geometry=GeometryHandler.getGeometryObject(area.get("AREA_COORDINATES")==null?"":(area.get("AREA_COORDINATES").toString()+";"+zbs[0]));
		String xy = vehicle.get("LONGI")==null||vehicle.get("LATI")==null?"":(vehicle.get("LONGI") + "," + vehicle.get("LATI"));
		Geometry g2= GeometryHandler.getGeometryObject(xy);
		return geometry.contains(g2);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("#####system destroye#####");
	}
}


class PointCompare2 implements Comparator<Map<String, Object>> {
	@Override
	public int compare(final Map<String, Object> a, final Map<String, Object> b) {
		double d = String.valueOf(a.get("PX")).equals("null")?0.0:Double.parseDouble(String.valueOf(a.get("PX")));
		double d1 = String.valueOf(b.get("PX")).equals("null")?0.0:Double.parseDouble(String.valueOf(b.get("PX")));
		double d2 = String.valueOf(a.get("PY")).equals("null")?0.0:Double.parseDouble(String.valueOf(a.get("PY")));
		double d3 = String.valueOf(b.get("PY")).equals("null")?0.0:Double.parseDouble(String.valueOf(b.get("PY")));
		if ( d < d1) {
			return -1;
		} else if (d > d1) {
			return 1;
		} else if (d2 < d2) {
			return -1;
		} else if (d3 > d3) {
			return 1;
		} else {
			return 0;
		}
	}
}