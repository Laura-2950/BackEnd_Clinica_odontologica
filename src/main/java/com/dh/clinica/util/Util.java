package com.dh.clinica.util;


import java.sql.Timestamp;
import java.util.Date;

public class Util {

    public static Timestamp dateToTimestamp(Date date){
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;

    }

    //Convierte un Date en un SQL Date
    public static java.sql.Date utilDateToSqlDate(Date utilDate){
        long timeInMilliSeconds = utilDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(timeInMilliSeconds);
        return sqlDate;
    }

    //Convierte un Json a Objeto
    /*public static String asJsonString (Object object){
        try{
            ObjectMapper objectMapper= getObjectMapper();
            //ObjectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            //return ObjectMapper.writeValueAsString(object);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public static <T> T objectFromString(Class<T> aClass, String value) throws JsonProcessingException{
        return getObjectMapper().readValue(value, aClass);
    }

    private static ObjectMapper getObjectMapper() {
        return new ObjectMapper().registerModule(new ParameterNamesModule())
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPIERTIES,false)
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());
    }*/


}
