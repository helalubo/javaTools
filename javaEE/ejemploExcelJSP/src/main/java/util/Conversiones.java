
package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversiones {

    private static String FORMATO_FECHA = "dd-MM";

    public static String format(Date fecha) {
        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(fecha);
    }

    public static String format(String fecha) {
        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(fecha);
    }

}