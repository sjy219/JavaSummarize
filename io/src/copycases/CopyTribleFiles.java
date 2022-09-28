package copycases;

//--------------------复制多级文件夹-----------------\\
//单级文件夹，当前目录下只有文件，把当前目录和目录下的所有文件复制到指定位置
//把当前项目下的test目录，复制到io/src/colletionio/下
//思路：
//  1.创建源目录File对象，路径是test的绝对路径（srcFile)
//  2.创建目的File对象，路径是targetFile = new File(io/src/colletionio/)
//  3.写方法实现文件夹的复制，参数为数据源File对象和目的地目录File对象
//  4.判断数据源File对象是否是目录：
//        是：
//          a.在目的地目录文件夹下创建和数据源File名称一样的目录
//          b.获取数据源File对象的所有文件或者目录的File对象数组
//          c.遍历该数组，得到每一个File对象
//          d.把该File对象作为数据源File对象，递归调用复制文件夹的方法
//       否：
//          说明是文件，直接复制，采取字节流实现

import java.io.*;

public class CopyTribleFiles {
    public static void main(String[] args) throws Exception {
        //创建源目录File对象
        File srcFile = new File("D:\\java\\Projects\\JavaSummarize\\test");
        //创建目的地目录File对象
        File targetFile = new File("io/src/copycases");
        copyDir(srcFile, targetFile);

    }

    private static void copyDir(File srcFile, File targetFile) throws Exception {
        if (srcFile.isDirectory()) {
            String srcFileName = srcFile.getName();
            //创建目的目录文件File对象
            File tarDir = new File(targetFile, srcFileName);
            //判断tarDir是否存在，不存在则创建
            if (!tarDir.exists()) {
                tarDir.mkdir();
            }
            //获取源目录文件File对象下所有的文件和目录的File数组
            File[] listFiles = srcFile.listFiles();

            //遍历listFilss下面的File对象
            for (File ff : listFiles) {
//                String ffName = ff.getName();
//                File finalFile = new File(tarDir, ffName);
                copyDir(ff, tarDir);
            }

        } else {
//            String srcFileName = srcFile.getName();
//            File tarFile = new File(targetFile, srcFileName);
            copyFile(srcFile, targetFile);
        }
    }

    private static void copyFile(File srcFile, File targetFile) throws Exception {
        //创建文件字节输入流对象
//        FileInputStream fi = new FileInputStream(srcFile);
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(srcFile));
        String srcFileName = srcFile.getName();

        //创建文件字节输出流对象
//        FileOutputStream fo = new FileOutputStream(targetFile);
        File targFile = new File(targetFile, srcFileName);
        BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(targFile));

        //读写数据，一次读写一个字节数组
        byte[] bytes = new byte[1024];
        int len;
        while ((len = br.read(bytes)) != -1) {
            bw.write(bytes, 0, len);
        }

        //释放资源
        br.close();
        bw.close();

    }
}
