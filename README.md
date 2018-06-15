# DesignModeProjects4Peelson
一些常见或者实用的设计模式的分析思考和实例，通过这个过程来学习

- 创建型
    - 单例模式
    - 构建者模式
- 结构型
    - 代理模式
        - 静态代理
        - 动态代理
- 行为型
    - 状态模式
    - 策略模式

### 创建型

#### 单例模式

##### 分类

主要的代码实现和细节参照demo：https://github.com/escnqh/DesignModeProjects4Peelson/tree/master/SingletonPattern

- 懒汉
  - 普通
  - 线程安全型（单锁）
  - 静态内部类
  - 双锁
- 饿汉
  - 静态工厂
  - 枚举

##### 介绍

保证一个类仅有一个实例，并提供一个访问它的全局访问点。 当你想控制实例数目，节省系统资源的时候，可以使用单例模式。

一般来说单例模式遵循的设计思想都是判断系统是否已经有这个实例，没有就创建，有则返回。通过私有构造函数来保证对实例控制。

所以要注意的是getInstance() 方法中需要使用同步锁 synchronized (Singleton.class) 防止多线程同时进入造成 instance 被多次实例化。 

##### 优缺点

- 优点
  - 在内存中只有一个实例，减少了内存的开销，尤其是频繁的创建和销毁实例 
  - 避免对资源的多重占用（比如写文件操作） 
  - 控制所有访问在唯一实例上进行
- 缺点
  - 没有接口，不能继承 
  - 与单一职责原则冲突，一个类应该只关心内部逻辑，而不关心外面怎么样来实例化 （拆分出其他模块来执行，单例做一个入口） 
  - 一些不必要的内存引用，会造成内存溢出（要有内存释放机制）
  - 一些错误的引用，比如引用了不再使用的对象（典型的有对 Activity 的引用），会造成内存泄漏



##### 问题

1. 饿汉式基于 classloder 机制避免了多线程的同步问题，不过，instance 在类装载时就实例化，虽然导致类装载的原因有很多种，在单例模式中大多数都是调用 getInstance 方法， **但是也不能确定有其他的方式（或者其他的静态方法）导致类装载**，这时候初始化 instance 显然没有达到 lazy loading 的效果。 

   > 阅读：http://www.importnew.com/6579.html

   - 类什么时候被初始化

     - 实例通过使用new()关键字创建或使用class.forName()反射，但他有可能导致ClassNotFoundException。
     - 类的静态方法被调用
     - 类的静态域被赋值
     - 类的静态域被访问，而且它不是常量
     - 在顶层类中执行assert语句

     反射同样可以使类初始化，比如java.lang.reflect包下面的某些方法，JLS严格的说明：一个类不会被任何除以上之外的原因初始化。 

### 行为型

#### 状态模式

允许一个对象在其内部状态改变时改变它的行为。对象看起来似乎修改了它的类，(State Pattern)是设计模式的一种，属于行为模式。

状态模式主要解决的是当控制一个对象状态的条件表达式过于复杂时的情况。把状态的判断逻辑转移到表示不同状态的一系列类中，可以把复杂的判断逻辑简化。

##### 模式中的角色

1. 上下文环境（Context）：它定义了客户程序需要的接口并维护一个具体状态角色的实例，将与状态相关的操作委托给当前的Concrete State对象来处理。
2. 抽象状态（State）：定义一个接口以封装使用上下文环境的的一个特定状态相关的行为。
3. 具体状态（Concrete State）：实现抽象状态定义的接口。

![状态模式类图](https://img-blog.csdn.net/20160814210128174?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

##### 解决的问题&缺点

首先我的感觉是，状态模式能够很好地契合流程图，流程图中的一个个节点进行状态的判断，来控制节点跳转，以达到控制流程的目的。

在每一个节点中，他做到了将与特定状态相关的行为局部化，并且将不同状态的行为分割开来。

![20180604192211.png](https://github.com/escnqh/DesignModeProjects4Peelson/blob/master/20180604192211.png?raw=true)

另外，当代码中出现包含大量和对象状态有关的条件语句，状态模式将可以把每个条件放入一个独立的类（状态）中。这使得你可以根据对象自身的情况将对象的状态作为一个对象，这一对象可以不依赖于其他对象而独立变化。

如果将业务逻辑分成服务端和客户端，那么状态模式的好处就是把某一固定的流程状态的判断和控制放到了服务端的内部，使得客户端不用很多代码进行判断，来控制流程的跳转。

其次这样实现的话，我们可以把每个节点都分开来处理，当流程流传到某一步（节点）时，可以去写自己的节点流转方法。

其**缺点**就是显而易见的，State类之间耦合度比较高，并且会有许多许多的节点类。

##### 例子Demo

https://github.com/escnqh/DesignModeProjects4Peelson/tree/master/StateMode

### 结构型

#### 代理模式

在代理模式（Proxy Pattern）中，一个类代表另一个类的功能（来达到提供一个代理以控制对这个对象的访问）。这种类型的设计模式属于结构型模式。在代理模式中，我们创建具有现有对象（Real）的对象（Proxy），以便向外界提供功能接口。

##### 解决的问题

在直接访问对象时带来的问题，比如说：要访问的对象在远程的机器上。在面向对象系统中，有些对象由于某些原因（比如对象创建开销很大，或者某些操作需要安全控制，或者需要进程外的访问），直接访问会给使用者或者系统结构带来很多麻烦，我们可以在访问此对象时加上一个对此对象的访问层。

于是乎，这种以增加中间层的模式，给我们提供了控制访问的手段。

几种场合：
1. 远程代理，也就是为一个对象在不同的地址空间提供局部代表，这样可以隐藏一个对象存在于不同地址空间的事实。比如说 WebService，当我们在应用程序的项目中加入一个 Web 引用，引用一个 WebService，此时会在项目中声称一个 WebReference 的文件夹和一些文件，这个就是起代理作用的，这样可以让那个客户端程序调用代理解决远程访问的问题；

2. 虚拟代理，是根据需要创建开销很大的对象，通过它来存放实例化需要很长时间的真实对象。这样就可以达到性能的最优化，比如打开一个网页，这个网页里面包含了大量的文字和图片，但我们可以很快看到文字，但是图片却是一张一张地下载后才能看到，那些未打开的图片框，就是通过虚拟代里来替换了真实的图片，此时代理存储了真实图片的路径和尺寸；(我猜小米相册删除相片这么快就是一种方式，在代理类中反馈删除结果，在实际类中做耗时的删除动作)

3. 安全代理，用来控制真实对象访问时的权限。一般用于对象应该有不同的访问权限的时候；

4. 指针引用，是指当调用真实的对象时，代理处理另外一些事。比如计算真实对象的引用次数，这样当该对象没有引用时，可以自动释放它，或当第一次引用一个持久对象时，将它装入内存，或是在访问一个实际对象前，检查是否已经释放它，以确保其他对象不能改变它。这些都是通过代理在访问一个对象时附加一些内务处理；

5. 延迟加载，用代理模式实现延迟加载,在真正使用对象数据时才去数据库或者其他第三方组件加载实际的数据，从而提升系统性能。

##### 优点和缺点

- 优点
    - 职责清晰
    - 很高的扩展性
    - 智能化
- 缺点
    - 由于在客户端和真实主题之间增加了代理对象，因此有些类型的代理模式可能会造成请求的处理速度变慢。
    - 实现代理模式需要额外的工作，有些代理模式的实现非常复杂。

##### 三个角色

- 抽象主题角色
    - 声明真实主题和代理主题的公共接口
    - 使用者针对抽象主题角色编程
- 代理者角色
    - 持有对真实主题角色的引用，可以代理真实主题角色执行某些任务；可以控制真实主题角色的访问
    - 可以控制真实主题的创建和销毁（隔断作用）
- 真实主题角色
    - 实现了真实的业务操作。由代理主题角色来间接调用完成操作

##### Demo

https://github.com/escnqh/DesignModeProjects4Peelson/tree/master/ProxyPattern

