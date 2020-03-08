package com.tazine.codeplay.gis.geojson;

import com.alibaba.fastjson.JSONObject;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.WKTReader;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.geotools.geojson.geom.GeometryJSON;

/**
 * @author jiaer.ly
 * @date 2020/03/07
 */
public class WktTools {

    public static void main(String[] args) {

        String wkt = "POINT(114.298456 30.553544)";

        Map<String,Object> map = new HashMap<String,Object>();

        map.put("name", "北清路");

        map.put("author","李雷");

        String json = geoToJson(wkt,map);

        System.out.println(jsonToWkt(json));

    }

    //
    public static String geoToJson(String wkt,Map<String,Object> map) {
        String json = null;
        try {
            WKTReader reader = new WKTReader();
            Geometry geometry = reader.read(wkt);
            StringWriter writer = new StringWriter();
            GeometryJSON g = new GeometryJSON();
            g.write(geometry, writer);

            map.put("geometry", writer);

            json = JSONObject.toJSONString(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    public static String jsonToWkt(String geoJson) {
        String wkt = null;
        GeometryJSON gjson = new GeometryJSON();
        Reader reader = new StringReader(geoJson);
        try {
            Geometry geometry = gjson.read(reader);

            wkt = geometry.toText();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wkt;
    }

}
