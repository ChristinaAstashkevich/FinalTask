package utility;

public class Random {
    private static final String AB_ENG = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxwy";
    private static final String AB_RUS = "ЙЦУКЕНГШЩЗХЪЭЖЛДОРПАВЫФЯЧСМИТЬБЮйцукенгшщзхъэжлдорпавыфячсмитьбю";
    private static java.util.Random rnd = new java.util.Random();

    public static String getRandomStringEng(int len){
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
        {
            sb.append(AB_ENG.charAt(rnd.nextInt(AB_ENG.length())));
        }
        return sb.toString();
    }

    public static String getRandomStringRus(int len){
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
        {
            sb.append(AB_RUS.charAt(rnd.nextInt(AB_RUS.length())));
        }
        return sb.toString();
    }
}
