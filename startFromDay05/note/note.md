# day08

> day08【课程发布-课程大纲和课程发布】- 02-课程管理-添加课程信息完善.mp4

课程简介添加失败，以后再说，搞不定就用原来那个。

# day09

## 413 Request Entity Too Large

### 现象

![image-20201122103513759](image/image-20201122103513759.png)

### 原因

Nginx默认的 request body 为1M，我上传的视频超过 1M

### 解决方法

打开 nginx.conf 配置文件，在http{}中加入  `client_max_body_size 1024m;` ，然后重启nginx。这样，Nginx的 request body 就改成了 1024 M

![image-20201122105213188](image/image-20201122105213188.png)

# day14

## localhost:3000/player/null

添加课程时 `edu_video.video_source_id`  字段 **null**，导致无法播放。

### 解决方法

#### 视频里的方法

视频里的做法是： 手动到管理控制台复制上传视频的 id 到 `edu_video.video_source_id` 对应的行中，显然这样是不好的。

#### 正确的方法

应该修改添加课程的模块，使数据库中 `edu_video.video_source_id` 为所上传视频的 ID 

### 参考

> day14【首页课程和名师功能】- 17-整合阿里云播放器播放（2）.mp4

