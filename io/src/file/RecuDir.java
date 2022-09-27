package file;

/*
* 需求：给定一个路径，通过递归完成遍历该目下的所有内容，并把所有文件的绝对路径输出到控制台
* 思路：
*   1.根据给定的路径创建一个File对象
*   2.定义一个方法，用于获取给定目录下的所有内容，参数为第一步创建的File对象
*   3.获取给定的File目录下所有的文件或目录的File数组
*   4.遍历该数组，得到每一个File对象
*   5.判断该File对象是否是目录
*       是：把File对象作为参数传递给递归调用方法，继续递归
*       否：获取绝对路径，输出到控制台
*   6.调用方法
* */

import java.io.File;

public class RecuDir {
    public static void main(String[] args) {
        //创建抽象路径名File对象
        File file = new File("D://java//book");
        //定义递归方法
        recu(file);

    }

    public static void recu(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File ff : listFiles) {
                if (ff.isDirectory()) {
                    recu(ff);
                } else {
                    System.out.println(ff.getAbsolutePath());
                }
            }
        }
    }
}
