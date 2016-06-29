# -
android 开启后台长期运行的服务（在退出应用程序之后依然运行）实现方式

1. 通过startServicr()启动服务，然后在onStartCommand() 中发送广播，在广播中再次启动服务，形成一个死循环。
