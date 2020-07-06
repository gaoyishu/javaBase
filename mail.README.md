#### 用原生java 发邮件
工具和思路还是比较简单的。

----------------------
##### 工具：
mail 和 activation 包

----
思路：
邮件发送过程：
* session 类创建 transport 工具用来发送。
* MimeMessage 创建 message 类用来装信息。
* message 中定义 邮件主题，邮件接收方，邮件内容。
* 使用 transport 把 message 发出去。

邮件接收过程：
* session 类创建 store 对象接收。
* 接收传过来的 message。
* 解析 message。
