package copycases;

//--------------------复制单级文件夹-----------------\\
//单级文件夹，当前目录下只有文件，把当前目录和目录下的所有文件复制到指定位置
//把当前项目下的test目录，复制到io/src/copycases下
//思路：
//  1.创建数据源目录File对象，路径是当前目录下的test文件夹
//  2.获取数据源目录File对象的名称test
//  3.创建目的地目录File对象，路径名是：test + io/src/copycases
//  4.判断目的地目录对应的File对象是否存在，如果不存在，就创建
//  5.获取数据源目录对象下的所有文件的File数组
//  6.遍历File数组，得到每一个File对象，该File对象，其实就是数据源文件
//  7.获取该数据源文件File对象的名称name
//  8.创建目的地文件File对象，路名称是:目的地目录+name组成
//  9.复制文件
//      由于文件不仅仅有文本文件，还有其它格式的文件，所以这里采用字节流复制文件

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopySingleFiles {
    public static void main(String[] args) throws Exception {
        File srcFile = new File("D:/java/Projects/JavaSummarize/test");
        File targetFile = new File("io/src/copycases");
        copyFile(srcFile, targetFile);

    }

    public static void copyFile(File source, File target) throws Exception {
        //获取数据源目录的名字
        String srcFileName = source.getName();

        //创建目的地对象，并判断是否包含数据源目录同名的目录
        File targetFile = new File(target, srcFileName);
        //如果目的目录下不存在所复制的目录，则创建
        if (!targetFile.exists()) {
            targetFile.mkdir();
        }
        //如果存在，列出源目录下的所有文件
        File[] listFiles = source.listFiles();
        for (File ff : listFiles) {
            String ffName = ff.getName();
            FileInputStream fi = new FileInputStream(ff);
            FileOutputStream fo = new FileOutputStream(new File(targetFile, ffName));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fi.read(bytes)) != -1) {
                fo.write(bytes, 0, len);
            }
            fi.close();
            fo.close();
        }

    }
}
