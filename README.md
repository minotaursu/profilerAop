# profiler 
## 基于springAop的调用链性能分析,使用webx的profiler类进行分析。   
调用链展示结果如下。
```
0 [76ms (13)ms, 100%] - com.minotaur.profiler.ProfilerDemoImpl:rootMethod(param:1)
+---12 [38ms (14)ms, 50%] - com.minotaur.profiler.ProfilerServiceImpl:onedotone(param:1)
|   +---25 [12ms, 16%] - com.minotaur.profiler.ProfilerDAOImpl:twodotone(param:1)
|   `---38 [12ms, 16%] - com.minotaur.profiler.ProfilerDAOImpl:twodottwo(param:1)
`---51 [25ms (12)ms, 33%] - com.minotaur.profiler.ProfilerServiceImpl:onedottwo(param:1)
    `---63 [13ms, 17%] - com.minotaur.profiler.ProfilerDAOImpl:twodottwo(param:1)
```
