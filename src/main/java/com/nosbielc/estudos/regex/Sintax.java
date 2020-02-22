package com.nosbielc.estudos.regex;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sintax {

    private static String metaData = "create external table UO.TBUO033_MAPA_CRTO (\n" +
            "\t\n" +
            "\tNUM_CPF_CNPJ \tbigint,\n" +
            "\tVRNE \t\t\tstring,\n" +
            "\tVRNE_MERC \t\tstring,\n" +
            "\tCOD_SGTO \t\tstring,\n" +
            "\tGRUP_BANC \t\tstring\n" +
            ")\n" +
            "partitioned by (ANOMES int) ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' \n" +
            "STORED AS INPUTFORMAT 'org.apache.hadoop.mapred.TextInputFormat' \n" +
            "OUTPUTFORMAT 'org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat'\n" +
            "LOCATION 'hdfs://nameservice1\\user\\hive\\warehouse\\uo.db\\tbuo033_mapa_crto'";

    public static void main(String[] args) {

        //Pattern patternGuilerme = Pattern.compile("'(.*?)'");
        Pattern pattern = Pattern.compile("(?i)\\s*CREATE\\s+(?:TEMPORARY\\s+)?EXTERNAL\\s+?TABLE\\s+?(?:(?:.+\\.)?\\w+)\\s*(?:\\w+)\\s\\(\\s*((?:\\w+?\\s*(?:\\w+?)?(?:\\s*,\\s*)?)+)\\s*\\)");
        Matcher matcher = pattern.matcher(metaData);

        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }

        //System.out.println(StringUtils.substringBetween(metaData,
        //        "UO.TBUO033_MAPA_CRTO (",
        //        ")\npartitioned by "));


    }

}
