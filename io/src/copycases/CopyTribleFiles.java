package copycases;

//--------------------复制多级文件夹-----------------\\
//单级文件夹，当前目录下只有文件，把当前目录和目录下的所有文件复制到指定位置
//把当前项目下的test目录，复制到io/src/colletionio/下
//

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

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
            String srcFileName = srcFile.getName();
            File tarFile = new File(targetFile, srcFileName);
            copyFile(srcFile, tarFile);
        }
    }

    private static void copyFile(File srcFile, File targetFile) throws Exception {
        //创建文件字节输入流对象
        FileInputStream fi = new FileInputStream(srcFile);

        //创建文件字节输出流对象
        FileOutputStream fo = new FileOutputStream(targetFile);

        //读写数据，一次读写一个字节数组
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fi.read(bytes)) != -1) {
            fo.write(bytes, 0, len);
        }

        //释放资源
        fi.close();
        fo.close();

    }
}
