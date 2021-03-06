#聪明账户文档说明
###聪明账户功能介绍
通过分析挖掘用户的关注股票，并对其进行模拟投资，结合市场因素，包括股市信息，市场因子等，从而分析出聪明账户群。并对聪明账户用户群进行定时分析，从而得到某支股票再聪明账户群中的关注度。


###建立聪明账户方式
* 每隔一个小时从hdfs上面获取用户的股票关注数文件

**注意：**
   此处有两套策略方式：
   每只股票收益率通用公式：value = 1*(close - open)/open
   close 为卖出时候的价格，open为买入时候的价格 
**策略1：**


*  ~~ 获取9点15分前，用户所有的关注的股票，然后获取 ~~
* 获取9点30时，用户关注的所有股票，假定此时所有股票买入，每个股票获取股票大盘信息，到11点半时候，早盘结束，假定此时所有股票卖出，当大盘信息，算出用户的收益率 
* 获取13点30时，用户关注所有的股票，假定此时所有股票买入，获取每个股票此时大盘的信息，设定到15点时，假定此时所有股票卖出，当大盘信息，算出用户的收益率
* 获取9点30时，用户关注所有的股票，假定此时所有股票买入，获取每个股票此时大盘的信息，设定到15点时，假定此时所有股票卖出，当大盘信息，算出用户的收益率

* 计算出回报率后，输出排行榜。包含 1天，3天，7天，15天，30天回报率排行榜(暂定1天)
* 从中筛选出排名靠前的20%用户作为聪明账户，并将用户ID输出(暂定前100 )
* 爬虫通过用户ID定时获取用户的关注股票数

* 策略1流程图：

![策略1流程图](/pic/strategy1.jpg)


###高手看涨实现方式
* 爬虫在一段时间内获取聪明账户关注股票
* 分析用户股票的变化数。
* 并统计出来股票的增长率和减少率。
 
 
## 1功能模块
### 1.http模块
#### http请求基类模块：包含GET/POST两种方式，并能够支持异步请求
#### http请求结果回调队列：将返回结果放于队列中，用于一个独立对象来管理
#### 将所有请求根据业务单独封装
### 2.stock模块
### 3.读取信息模块
### 4.计算收益率
### 5.排行榜模块
### 6.看涨/跌模块
### 7.log模块
