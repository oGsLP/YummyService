## 项目选择： Yummy

# -项目设计-

### 项目技术
#### MyBatis + Spring Boot + SpringMVC + Vue
#### 其余： 


### 项目用户主体
#### 会员
#### 餐厅
#### 经理

##### 项目据此分为三个模块，其中会员餐厅两个并列的登录入口，经理作为root用户有单独的入口

### 项目需求
#### 会员
#### 会员、级别策略、订单

##### 1.1 会员注册
* 邮箱注册
* 邮箱验证（链接）
* 密码

##### 1.2 会员注销
* 不可恢复
* 保留数据

##### 1.3 会员信息
* 增删改信息（电话，姓名，可能多个的地址，支付账户，支付密码）
* 其余信息： 账户余额，等级，账户有效性，
* 统计信息： 点餐、退订、消费（按时间，金额，餐厅分类）

##### 2 会员级别策略
* 根据消费情况自定义，级别存在优惠政策

##### 3.1 点餐
* 用户选择商家以及菜品、套餐，选择时间、地点，生成订单
* 其中系统根据地点判定可行性

##### 3.2 支付
* x分钟计时，支付，自动取消
* 支付模拟网银操作（密码、验证？？）

##### 3.3 退订
* 根据逾期期限退还百分比，策略自定


#### 餐厅
#### 餐厅、发布、接单、统计

##### 1 餐厅注册
* 分配7位标识码
* 信息： 名称，地点，类型，电话 ---修改需经理审批
* 审批后上架

##### 2 发布菜单
* 菜品 ： 名称，价格，数量，类型，时限
* 套餐 ： 商家组合
* 优惠 ： 自定义

##### 3 送餐 

##### 4 统计
* 订单情况（点餐、退订）
* 财务状况
* 时间、金额、会员等分类

#### 经理
#### 审批，策略制定，统计

##### 1 审批
* 审批餐厅注册信息

##### 2 策略制定
* 订单的抽利、退订、可行性判断等设定
* 餐厅、会员、财务统计



### -数据库设计-

#### 会员
* t_member
* id int pk ++
* email varchar(20) 
* password varchar(20)
* phone varchar(20)
* name varchar(20)
* level int // enum
* validation int // enum

#### 会员支付账号
* t_member_payment
* id int pk ++
* mem_id fk
* account varchar(20)
* password varchar(20)
* balance double

#### 地址
* t_address
* id int pk ++
* longitude double
* latitude double
* note varchar(256)

#### 会员地址
* t_member_address
* id int pk ++
* mem_id fk
* ad_id fk

#### 会员等级优惠政策（打折）
* t_member_discount
* id int pk ++
* level int 
* discount double //0.01-0.99

#### 餐厅
* t_merchant
* id int pk ++
* cdkey varchar(7)
* name varchar(20)
* type varchar(20) // enum 'other' 其他
* phone varchar(20)
* ad_id fk
* vertification int // enum


#### 餐厅优惠政策（满减）
* t_merchant_discount
* id int pk ++
* mer_id fk
* min int // 满
* discount int // 减

#### 菜单菜品
* t_dish
* id int pk ++
* mer_id fk
* name varchar(20)
* price double
* supply int 
* kind varchar(20) // enum
* deadline timestamp

#### 菜单套餐
* t_pack
* id int pk ++
* mer_id fk
* name varchar(20)
* price double
* deadline timestamp

#### 菜单菜品套餐中间表
* t_dish_pack
* id int pk ++
* pack_id fk
* dish_id fk
* num int 

#### 订单
* t_deal
* id int pk ++
* mem_id fk
* mer_id fk
* origin_price double
* mem_discount double
* mer_discount int
* final_price double
* profit double
* actual_benefit double
* state int // enum
* refund double
* limit_time int 
* setup_time timestamp

#### 订单菜品
* t_deal_dish
* id int pk ++
* deal_id fk
* dish_id fk
* num int

#### 订单套餐
* t_deal_pack
* id int pk ++
* deal_id fk
* pack_id fk
* num int

#### 平台利息（百分比）
* t_profit
* id int pk ++
* ratio double(1-99.9)
* effect_date timestamp

#### 平台收入
* t_income
* id int pk ++
* deal_id fk
* profit_id fk
* ...

### util 工具
* 生成7位识别码
* 生成验证码
* 密码加密
* 邮箱服务api
* 地址服务api
* 日志服务

### Service 逻辑层
* MemberLoginService
  * register
  * checkKey
  * login
  * cancelAccount
* MemberManageService
  * getInfo
  * modifyInfo
  * addAddress
  * deleteAddress
  * modifyAddress
* PayService
  * addPayment
  * checkPayment
  * pay
  * refund
* MerchantManageService
  * apply
  * login
  * submitInfo
  * getInfo
* DishManageService
  * getDishes
  * addDish
  * modifyDish
  * deleteDish
  * getPacks
  * addPack
  * modifyPack
  * deletePack
* ShopService
  * getMerchants
  * getCurrentDishes
  * getCurrentPacks
* DealManageService
  * checkDistance
  * generateDeal
  * confirmDeal
  * cancelDeal
  * payDeal
  * refundDeal
  * completeDeal
* AdminManageService
  * getRatio
  * getRatios
  * modifyRatio
  * getLevels
  * modifyLevels
  * failApply
  * passApply
* MemberDataGatherService
  * showAllDeals
  * showBalance
  * showDealsInADay
  * showDealsInAWeek
  * showDealsInAMonth
  * ....
* MerchantDataGatherService
  * .....
* AdminDataGatherService
 * ......