# android_ProjectFrame

#侧滑主页：SlidingMenu
com.chengbiao.ricky.projectframe.slidingmenu.SlidingMenu

#下来刷新、上拉加载：pullrefreshview
com.chengbiao.ricky.projectframe.slidingmenu.SlidingMenu




#关于代码混淆：
集成百度地图SDK的应用，在打包混淆的时候，需要注意与地图SDK相关的方法不可被混淆。混淆方法如下：
-keep class com.baidu.** {*;}
-keep class vi.com.** {*;}
-dontwarn com.baidu.**
保证百度类不能被混淆，否则会出现网络不可用等运行时异常