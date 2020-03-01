package Medium;

public class P165_CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        while (version1.length() > 0 || version2.length() > 0) {
            int v1 = 0, v2 = 0;
            if (version1.length() > 0) {
                int point1 = version1.indexOf(".");
                if (point1 == -1) {
                    v1 = Integer.parseInt(version1);
                    version1 = "";
                } else {
                    v1 = Integer.parseInt(version1.substring(0, point1));
                    version1 = version1.substring(point1 + 1);
                }
            }
            if (version2.length() > 0) {
                int point2 = version2.indexOf(".");
                if (point2 == -1) {
                    v2 = Integer.parseInt(version2);
                    version2 = "";
                } else {
                    v2 = Integer.parseInt(version2.substring(0, point2));
                    version2 = version2.substring(point2 + 1);
                }
            }
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int i = new P165_CompareVersionNumbers().compareVersion("1.0", "1.0.0");
        System.out.println("i = " + i);
    }
}
