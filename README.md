# bigDataService

安博会大数据展示后台接口
1. 使用IntelliJ IDEA菜单建立本地Git仓库: VCS -> Import into Version Control -> Create Git Repository；
2. 在弹出的的窗口中选择当前项目；
3. 提交全部需要管理的文件到新建立的本地仓库master分支；
4. 在idea的Terminal里面输入: git remote add origin  http//<IP地址:端口号>/服务器相对路径/仓库名
5. 当第4步完成以后输入: git push origin master
6. 如果第五步出现问题就先执行 git pull origin master然后在执行 git push origin master.
7. 在terminl窗口中依次输入命令：
    1. git pull  
    2. git pull origin master 
    3. git pull origin master --allow-unrelated-histories  
8. MySql设置重启，自动开启定时任务计划,在你的my.ini 的 [mysqld} 节中添加
``` 
  event_scheduler = ON 
```
9. MYSQL5.7版本sql_mode=only_full_group_by问题，在你的my.ini 的 [mysqld} 节中添加
``` 	
 sql_mode=STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION;
```
 
  