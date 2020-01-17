package com.nosbielc.estudos.regex;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Cleibson Gomes (https://github.com/Nosbielc) ON 15/01/2020
 * @project EstudosJDK8
 */
public class Validacao {

    private static String metaData = "create external table UO.TBUO033_MAPA_CRTO (\n" +
            "\n" +
            "NUM_CPF_CNPJ \tbigint,\n" +
            "VRNE \t\t\tstring,\n" +
            "VRNE_MERC \t\tstring,\n" +
            "COD_SGTO \t\tstring,\n" +
            "GRUP_BANC \t\tstring\n" +
            ")\n" +
            "partitioned by (ANOMES int) ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'\n" +
            "STORED AS INPUTFORMAT 'org.apache.hadoop.mapred.TextInputFormat'\n" +
            "OUTPUTFORMAT 'org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat'\n" +
            "LOCATION 'hdfs://nameservice1\\user\\hive\\warehouse\\uo.db\\tbuo033_mapa_crto'";

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(?i)\\s*CREATE\\s+(?:TEMPORARY\\s+)?EXTERNAL\\s+?TABLE\\s+?(?:(?:.+\\.)?\\w+)\\s*(?:\\w+)\\s\\(\\s*((?:\\w+?\\s*(?:\\w+?)?(?:\\s*,\\s*)?)+)\\s*\\)");
        Matcher matcher = pattern.matcher(metaData);
        if (matcher.find())
        {
            System.out.println(matcher.group(1));
        }

//        System.out.println(
//                StringUtils.substringBetween(metaData, "table UO.TBUO033_MAPA_CRTO (", ")\npartitioned by "));
        System.out.println(
                        StringUtils.substringBetween(metaData, "table UO.TBUO033_MAPA_CRTO (", ")\npartitioned by "));


    }

}
