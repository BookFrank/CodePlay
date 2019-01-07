1. 使用 npm init 生成一个 npm 项目，会生成一个 package.json 的文件

2. 使用 npm install 可以本地安装项目所使用的依赖

3. cnpm install vue --save 
在安装模块时，只有当事人知道安装了哪些模块，如果换另外一个人来看这个项目，是不会知道这个项目安装了哪些模块。
使用 --save 可以在安装模块时，同时将安装的模块信息记录在 package.json 文件中，这样第三个人再看这个项目时，就可以直接看 package.json 文件来了解这个项目依赖了哪些包
与 --save 参数类似，--save-dev 也会将模块信息记录到 package.json 文件中，不同的是记录在文件中的 devDependencies 属性下
