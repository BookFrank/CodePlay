// javascript 面向对象编程

var Student = {
    name: 'Robot',
    height: 1.8,
    run(){
        console.log(this.name + " is running");
    }
}

console.log(Student.name);
Student.run();

var xiaoming = {
    name: 'xiaoming'
}

// 将xiaoming的原型指向对象 Student
xiaoming.__proto__ = Student;

// javascript的原型链和Java的Class的区别在于，没有 Class 的概念，所有对象都是实例，所谓继承关系不过是把一个对象的原型指向另一个对象而已
console.log(xiaoming.name);
console.log(xiaoming.run());


function createStudent(name, height){
    // 基于 Student 原型创建一个新对象，create 方法传入一个原型对象，并创建一个基于该原型的新对象，但是新对象没有属性
    var s = Object.create(Student);
    // 初始化新对象
    s.name = name;
    s.height = height;
    return s;
}

var lilei = createStudent('lilei', 1.7);
lilei.run();
console.log(lilei.__proto__ === Student);