// 定义一个类
function Person(){
    console.log("创建对象成功");
}

var Person2 = function(){

}

const Person3 = {
    intro: function () {
        console.log("创建对象成功--");        
    }
}

// 创建对象-类的实例
var person1 = new Person();

var person2 = new Person();

var person3 = Object.create(Person3);
person3.intro();


// 真正创建一个对象

// 调用方法很像存取一个属性，不同的是 add() 在方法名后面很可能带着参数；
// 为定义一个方法，需要将一个函数赋值给类的 prototype 属性，这个赋值给函数的名称就是用来给对象在外部调用的

function Player(name) {
    this.name = name;
}

Player.prototype.sayHello = function(){
    console.log("Hi, I am " + this.name);
}

var kobe = new Player("kobe");
var hiFunc = kobe.sayHello;

kobe.sayHello();
hiFunc.call(kobe);
hiFunc(); // Hi, I am undfined

// 在 Javascript 中，方法通常是一个绑定到对象中的普通函数，这意味着方法可以再其所在的 context 之外被调用
// 上面所有的使用方式，都指向了 sayHello 函数的引用；
// 在调用函数的过程中，this的值取决于我们怎样调用函数，在通常情况下，我们通过一个表达式 kobe.sayHello() 来调用函数，
// 即从一个对象的属性中得到所调用的函数，此时 this 被设置为我们去的函数的对象即 kobe。

// 不同的调用方法，this 值也不相同。当从变量 hiFunc() 中调用的时候，this就被设置成了全局对象，在浏览器中就是window。

console.log(hiFunc === kobe.sayHello); // true
console.log(hiFunc === Player.prototype.sayHello); // true



