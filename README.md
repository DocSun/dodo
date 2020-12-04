# DODO 
 >> 取名：来自我家猫的名字，包名中的nnx代表：nine-nine-six(手动微笑)
 
 DODO只是实现一个简单的rpc架，完成最基本的rpc功能，空闲时会不断迭代，希望可以最终呈现一个完善的rpc架构
# 代码构思
初步构思这个框架分为四个部分：
1. 服务端 dodo-server：提供服务，在启动时将服务注册进服务的配置中心，包括服务的名称、服务版本、服务组号以及服务端的ip和端口号
2. 配置中心 dodo-config-server：接收来自服务端的注册的服务，并存储起来，并提供负载均衡策略，能够根据服务端机器的实时状况，返回状况较好的服务端的ip地址
3. 客户端 dodo-client：消费服务端提供的服务，能够像调用本地方法一样使用服务端的服务
4. 公共模块 dodo-common：公共模块提供了一些基础的功能
* 公共模块提供的功能主要如下：
  * 客户端数据传输的序列化和服务端进行反序列化的工具、提供服务端
  * 提供端到端通信的能力（这一块准备先暂时使用socket通信，后续看能否接入netty）
  * 提供服务端的服务注册注解，并能够协助服务端将服务注册到配置中心，服务端服务的提供只需要在需要外放的服务接口上标明注解，无需其他操作便完成服务的注册
  * 类似上面，提供客户端的消费服务的能力，协助客户端请求配置中心，得到真正服务的提供者的ip
  * 提供调用远程方法的能力，主要是通过代理模式和反射机制
  
**可以看到这个rpc框架的核心是公共模块和配置中心模块，最终要达到的效果是：服务端提供rpc服务只需要一个注解，客户端消费服务只需要一个注解，将客户端和服务端
通信的过程使用一个黑盒（公共模块和配置中心）给封装起来了。**

具体架构图可参照：[!框架示意图](./框架示意图.vsdx)

