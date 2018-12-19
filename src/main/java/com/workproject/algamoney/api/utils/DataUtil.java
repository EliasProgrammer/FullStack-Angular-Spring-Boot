package com.workproject.algamoney.api.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Classe útil para trabalhar com datas. 
 * @author Elias
 */
public class DataUtil {

	public static final Locale LOCALE_BRAZIL = new Locale("pt","BR");
	public static final SimpleDateFormat FORMATTER_EXTENSO = new SimpleDateFormat("dd 'de' MMMMM 'de' yyyy");
	public static final SimpleDateFormat FORMATTER_DDMM = new SimpleDateFormat("dd/MM");
	public static final SimpleDateFormat FORMATTER_DDMMYYYY = new SimpleDateFormat("dd/MM/yyyy");
	public static final SimpleDateFormat FORMATTER_DATA_HORA = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public static final SimpleDateFormat FORMATTER_TIMESTAMP = new SimpleDateFormat("YYYY-MM-dd HH:mm:ssZ");
	
	private static Calendar calendar = Calendar.getInstance(LOCALE_BRAZIL);
	
	public static String formatarExtenso(Date data) {
		return FORMATTER_EXTENSO.format(data);
	}
	
	public static String formatarDDMM(Date data) {
		return FORMATTER_DDMM.format(data);
	}
	
	public static String formatarDDMMYYYY(Date data) {
		return FORMATTER_DDMMYYYY.format(data);
	}
	
	public static String formatarDataHora(Date data) {
		return FORMATTER_DATA_HORA.format(data);
	}
	
	public static String formatarTimestamp(Date data) {
		return FORMATTER_TIMESTAMP.format(data);
	}
	
	public static int getMes(Date data){
		calendar.setTime(data);
		return calendar.get(Calendar.MONTH)+1;
	}

	public static int getDiaDoMes(){
		return hoje().get(Calendar.DAY_OF_MONTH);
	}
	
	public static int getDiaDoMes(Date data){
		calendar.setTime(data);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	public static int getAno(Date data){
		calendar.setTime(data);
		return calendar.get(Calendar.YEAR);
	}
	
	public static int getAno(){
		return hoje().get(Calendar.YEAR);
	}
	

	public static boolean mesmoDia(Date d1, Date d2){
		Calendar c1 = zerarHora(d1);
		Calendar c2 = zerarHora(d2);
		return  (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)) && (c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR));
	}
	
	public static Calendar hoje(){
		return zerarHora(Calendar.getInstance(LOCALE_BRAZIL));
	}
	
	public static Calendar novaInstancia(int dia, int mes, int ano){
		Calendar c1 = hoje();
		c1.set(ano, mes-1, dia);
		return zerarHora(c1);
	}
	
	public static Calendar zerarHora(Calendar calendar){
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}
	public static Calendar zerarHora(Date data){
		Calendar c1 = Calendar.getInstance(LOCALE_BRAZIL);
		c1.setTime(data);
		return zerarHora(c1);
	}
}
