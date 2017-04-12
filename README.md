# profiler tree aop
基于springAop的调用链性能分析,使用webx的profiler类进行分析。  
在profiler日志中打印调用树和开销。
调用链展示结果如下。
```
0 [76ms (13)ms, 100%] - com.minotaur.profiler.ProfilerDemoImpl:rootMethod(param:1)
+---12 [38ms (14)ms, 50%] - com.minotaur.profiler.ProfilerServiceImpl:onedotone(param:1)
|   +---25 [12ms, 16%] - com.minotaur.profiler.ProfilerDAOImpl:twodotone(param:1)
|   `---38 [12ms, 16%] - com.minotaur.profiler.ProfilerDAOImpl:twodottwo(param:1)
`---51 [25ms (12)ms, 33%] - com.minotaur.profiler.ProfilerServiceImpl:onedottwo(param:1)
    `---63 [13ms, 17%] - com.minotaur.profiler.ProfilerDAOImpl:twodottwo(param:1)
```
第一个字段是方法开始时间(相对值，单位毫秒)，第二字段是方法总耗时，带有括号的第三个字段是方法的自身耗时，第四个字段是方法耗时占root方法的耗时百分比。
例如 12 [38ms (14)ms, 50%] 代表12是相对开始毫秒数，38是方法总耗时，(14)是方法自身耗时，50%是方法onedotone的耗时38ms占rootMethod方法耗时76ms的50%

具体线上使用时可以将静态的ProfilerSwitch改为动态的ProfilerSwitch。该profiler经过线上大量验证，欢迎使用，欢迎提issues
