package com.tazine.third.geojson;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.WKTReader;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiaer.ly
 * @date 2020/03/01
 */
public class Test {

    public static void main(String[] args) {

        String wkt = "POINT(114.298456 30.553544)";

        Map<String,Object> map = new HashMap<String,Object>();

        map.put("name", "北清路");

        map.put("author","李雷");

        String json = geoToJson(wkt,map);

        System.out.println(jsonToWkt(json));

    }

    public static String wktToJson(String wkt) {
        String json = null;
        try {
            WKTReader reader = new WKTReader();
            Geometry geometry = reader.read(wkt);
            StringWriter writer = new StringWriter();
            GeometryJSON g = new GeometryJSON(20);
            g.write(geometry, writer);
            json = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

}
