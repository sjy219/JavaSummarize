# Properties
### 1. 构造方法：
   1. Properties()
   2. 继承自<font color = red>HashTable<Objet,Object></font>
### 2. 特有方法
   1. Object setProperty(String key, String value)
      1. 设置集合的键和值
   2. String getProperty(String key)
      1. 返回指定的键对应的值
   3. Set<String> stringPropertyName(): 返回值是键的集合，类型为String
3. **<font color=orange>和IO流结合的方法</font>**
   1. void load(InputStream in)
   2. void load(Reader reader)
   3. void store(OUtputStream out, String comments)
   4. void store(Write writer, String comments)
        1. 将proper中的键值对写入properties表中    
