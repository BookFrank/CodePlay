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

// 在 Javascript 中，方法通常是一个绑定到对象中的普通函数，这意味着方法可以再其所在的 context 之外被调用


kobe.sayHello();
hiFunc.call(kobe);
hiFunc(); // Hi, I am undfined

console.log(hiFunc === kobe.sayHello); // true
console.log(hiFunc === Player.prototype.sayHello); // true



