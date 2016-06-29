# -
android 开启后台长期运行的定时服务（在退出应用程序之后依然运行）实现方式

1. 通过startServicr()启动服务，然后在onStartCommand() 中发送广播，在广播中再次启动服务，形成一个死循环。

2. 说明： 如果是定时任务的话，具体执行任务部分的代码可以放在 service的onStartCommand()方法中 或者是                 Receicver的onReceive()方法中都可以； 除此之外，如果是耗时操作的话，记得开启新的线程。
