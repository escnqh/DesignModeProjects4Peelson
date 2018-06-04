# DesignModeProjects4Peelson
一些常见或者实用的设计模式的分析思考和实例，通过这个过程来学习

- 创建型
- 结构型
- 行为型
    - 状态模式

### 状态模式
允许一个对象在其内部状态改变时改变它的行为。对象看起来似乎修改了它的类，(State Pattern)是设计模式的一种，属于行为模式。

状态模式主要解决的是当控制一个对象状态的条件表达式过于复杂时的情况。把状态的判断逻辑转移到表示不同状态的一系列类中，可以把复杂的判断逻辑简化。

#### 模式中的角色
1. 上下文环境（Context）：它定义了客户程序需要的接口并维护一个具体状态角色的实例，将与状态相关的操作委托给当前的Concrete State对象来处理。
2. 抽象状态（State）：定义一个接口以封装使用上下文环境的的一个特定状态相关的行为。
3. 具体状态（Concrete State）：实现抽象状态定义的接口。

![状态模式类图](https://img-blog.csdn.net/20160814210128174?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

#### 解决的问题&缺点
首先我的感觉是，状态模式能够很好地契合流程图，流程图中的一个个节点进行状态的判断，来控制节点跳转，以达到控制流程的目的。

在每一个节点中，他做到了将与特定状态相关的行为局部化，并且将不同状态的行为分割开来。


![流程图][1]

另外，当代码中出现包含大量和对象状态有关的条件语句，状态模式将可以把每个条件放入一个独立的类（状态）中。这使得你可以根据对象自身的情况将对象的状态作为一个对象，这一对象可以不依赖于其他对象而独立变化。

如果将业务逻辑分成服务端和客户端，那么状态模式的好处就是把某一固定的流程状态的判断和控制放到了服务端的内部，使得客户端不用很多代码进行判断，来控制流程的跳转。

其次这样实现的话，我们可以把每个节点都分开来处理，当流程流传到某一步（节点）时，可以去写自己的节点流转方法。

其**缺点**就是显而易见的，State类之间耦合度比较高，并且会有许多许多的节点类。

#### 例子Demo

https://github.com/escnqh/DesignModeProjects4Peelson/tree/master/StateMode



  [1]: https://github.com/escnqh/DesignModeProjects4Peelson/tree/master/StateMode/20180604192211.png