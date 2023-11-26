package Java.lebin.Training.ObjectOriented.day10Polymorphisn.utils;

import java.util.*;

public class CMUtility {
    private static Scanner scanner = new Scanner(System.in);
    /**
     * ���ܣ�����һ����Ч���ַ���ֵ��1����5
     * @return char
     */
	public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);//һ����Ч�ַ�
            c = str.charAt(0);//��String����ת����char����
            if (c != '1' && c != '2' && 
                c != '3' && c != '4' && c != '5') {
                System.out.print("ѡ��������������룺");
            } else break;
        }
        return c;
    }
	/**
	 * ���ܣ����ڷ������ⵥ���ַ�
	 * @return �����ַ�
	 */
    public static char readChar() {
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }
    
//    public static void main(String[] args) {
//		char ch = readChar('��');
//		System.out.println(ch);
//	}

    
    /**
     * ���ܣ����ֱ���ûس�������Ĭ��ֵ�����������Ч�ַ����򷵻��ַ�
     * @param defaultValue
     * @return
     */
    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);//����ûس�����ֱ�ӷ���""; ������ûس����򷵻�һ�����ַ�
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }

    
    /**
     * ���ܣ����ؼ����������������
     * @return
     */
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("��������������������룺");
            }
        }
        return n;
    }

    /**
     * ���ܣ�����ûس����򷵻�Ĭ��ֵ�����û���ûس����򷵻����������
     * @param defaultValue
     * @return
     */
    public static int readInt(int defaultValue) {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, true);
            if (str.equals("")) {
                return defaultValue;
            }

            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("��������������������룺");
            }
        }
        return n;
    }
    /**
     * ���ܣ����ز�����ָ�����ȵ���Ч�ַ���
     * @param limit
     * @return
     */
    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }
    /**
     * ���ܣ����ֱ���ûس����򷵻�Ĭ��ֵ�����û���ûس����򷵻��������Ч�ַ���
     * @param limit
     * @param defaultValue
     * @return
     */
    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("")? defaultValue : str;
    }
    /**
     * ���ܣ�����ȷ��ѡ�Ҫô��Y��Ҫô��N
     * @return
     */
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("ѡ��������������룺");
            }
        }
        return c;
    }

    
    /**
     * ���ܣ����ڽ��ܲ�����ָ���ĳ��ȵ��ַ���
     * @param limit ��󳤶�
     * @param blankReturn ���
     * @return ��Ч���ַ���
     */
    private static String readKeyBoard(int limit, boolean blankReturn) {//limit:1  ,blankReturn:true
        String line = "";

        while (scanner.hasNextLine()) {
        	/*
        	 * //nextLine��next���񣬶������ڽ��ܼ���������ַ���
        	 * next:����\n��\t��ո������ֻ�ܽ�����Щ�ַ�ǰ�����Ч�ַ���ʾ�������� 12345 6789�����յ����ǣ�12345
        	 * nextLine:����\n��������Ϊ\t��ո�Ϊ��Ч�ַ������Խ���\n֮ǰ�������ַ���ʾ�������룺12345 6789�����ܵ����ǣ�12345 6789
        	 */
            line = scanner.nextLine();//""    abc
            if (line.length() == 0) {//�൱������س�
                if (blankReturn) return line;//""
                else continue;//��Ҫ���ַ�����ϣ�����Լ���ѭ��ʵ�ּ������룬ֱ��������Ч�ַ�Ϊֹ
            }

            if (line.length() < 1 || line.length() > limit) {//�ж�������ַ����Ƿ񳬹�ָ���ĳ���
                System.out.print("���볤�ȣ�������" + limit + "���������������룺");
                continue;
            }
            break;
        }

        return line;
    }
}
