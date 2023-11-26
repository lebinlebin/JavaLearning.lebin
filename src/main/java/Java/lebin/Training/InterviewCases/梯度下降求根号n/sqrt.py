# https://www.jianshu.com/p/6dfba0d17169
import random
import matplotlib.pyplot as plt
import numpy as np
import math

class Solutin():
    #这个是求根号2
    # 梯度下降法（Gradient descent）
    # 若要求根号下2，即要求解 x ^ 2 - 2 = 0 的根，
    # 也就是函数 L=(x ^ 2 - 2)^2 取极小值时x的取值。这个也就对应机器学习中的损失函数。
    # dL/dx = 4*x^3-8x=4x(x^2-2)
    def gradient_descent(self,n):
        # 随机初始化
        x = float(random.randint(1, 100))#一个随机数
        # 学习率
        lr = 0.001
        # 记录损失
        loss = []
        # 损失阈值
        while ( abs(x ** 2 - n) > 0.0000000001 ):
            # x(n+1) = x(n) - lr * g(x(n))
            x = x - lr * 4 * x * (x ** 2 - n)
            # 记录损失
            loss.append((x ** 2 - n)**2)
        return loss,x


    def gradient_descent_root(self,n):
        # 随机初始化
        # 32  -32  -0.1  0.1
        x = float(random.uniform(-2.5, 2.5))#一个随机数
        print("-------->")
        print(x)
        # 学习率
        lr = 0.00001
        # 记录损失
        loss = []
        # 损失阈值
        while ( abs(x ** 5 - n) > 0.0000000001 ):
            # x(n+1) = x(n) - lr * g(x(n))
            x = x - lr * 10 * x**4 * (x ** 5 - n)
            # 记录损失
            loss.append((x ** 5 - n)**2)
        return loss,x


    # 牛顿迭代法（Newton’s method）
    # 把 f(x)在点x_0 的某邻域内展开成泰勒级数,取其线性部分（即泰勒展开的前两项），并令其等于0;以此作为非线性方程 的近似方程
    # 牛顿法用的是斜率的思想，对f(x)=0，选一个足够接近目标值(x)的点(x_0)，计算其切线与X轴的交点(x_1），
    # 这个交点x_1往往比x_0更接近x，数次迭代后肯定越来越接近目标值x。
    # 假设 f(x) = x^2 - n
    def sqrt_newton(self,n):
        x = n
        while (abs(x * x - n) > 0.0000000001):
            x = (x + n / x) / 2
            print(">>>>>>>>> sqrt_newton <<<<<<<<<<")
            print(x)
    #=========================================================


    def newton_method(self,n,tol=1e-6, max_iter=100):
        count = 0
        x0 = float(random.uniform(-2.5, 2.5))#一个随机数
        print(x0)
        loss = []
        while True:
            # x1 = x0 - f(x0)/df(x0)
            x1 = x0 - (x0 ** 5 - n) / (5 * x0 ** 4)
            if abs(x1 - x0) < tol:
                break
            x0 = x1
            count += 1
            loss.append((x0 ** 5 - n) ** 2)
            if count >= max_iter:
                raise ValueError("Iteration limit exceeded")
        return x1,loss
    #============================================================


    # 二分法
    # 一个数a的平方根小于等于a，使用二分法解决如下
    #其实需要判定一下我们求的结果所在的大概范围，然后再采用二分查找方法进行求解
    #这个方法可以求 开n次方根
    def mySqrt_BinarySearch(self, n):
        if n == 0:
            return 0
        if n == 1:
            return 1

        mid_result = []
        left = 0
        right = float(random.randint(1, 3))#一个随机数
        print("搜索区间为:["+str(left)+","+str(right)+"]")
        while left <= right:
            x = left + (right - left) // 2
            mid_result.append(x)
            if (abs(x * x - n) < 0.0001):
                print("find sucess!!!!")
                return x
            elif x * x > n:
                right = x - 0.0001
            else:
                left = x + 0.0001
        return -1

    #梯度下降解方程
    def gradient_f(self,n):
        x1, x2 = 1, 1  # first try
        lr = 0.01  # learning rate
        epsilon = 1e-4  # quit flag

        f_x = lambda x1, x2: (x1 - 3) ** 2 + (x2 + 4) ** 2
        dfx1 = lambda x: 2 * (x - 3)
        dfx2 = lambda x: 2 * (x + 4)
        delta_y = lambda x1, x2: f_x(x1, x2) - n
        e_x = lambda x1, x2: delta_y(x1, x2) ** 2 * 0.5  # cost function
        dedx1 = lambda x1, x2: delta_y(x1, x2) * dfx1(x1)  # partial derivative of loss \
        dedx2 = lambda x1, x2: delta_y(x1, x2) * dfx2(x2)  # with Chain Rule
        delt_x1 = lambda x1, x2: dedx1(x1, x2) * lr
        delt_x2 = lambda x1, x2: dedx2(x1, x2) * lr

        count = 0
        while abs(f_x(x1, x2) - n) > epsilon:
            count += 1
            x1 -= delt_x1(x1, x2)
            x2 -= delt_x2(x1, x2)
        return x1, x2, count

    def arcsin(self,n):
        x = 1  # first try
        lr = 0.1  # learning rate
        epsilon = 1e-8  # quit flag

        f_x = lambda x: math.sin(x)
        delta_y = lambda x: f_x(x) - n
        delta_x = lambda x: delta_y(x) * math.cos(x) * lr

        while abs(f_x(x) - n) > epsilon:
            x -= delta_x(x)

        return math.degrees(x)





if __name__ == '__main__':
    # n=2
    # loss,a = Solutin().gradient_descent(n)
    # print(a)
    #
    # # 画损失图
    # x = range(len(loss))
    # plt.plot(x, loss, color='b')
    # plt.xlim(0,1000)
    # plt.show()

    # n = 2
    # Solutin().sqrt_newton(n)
    # result,loss = Solutin().newton_method(0.1)
    # print(result,loss)
    # print(result)
    # plt.figure(facecolor='gray')
    # plt.plot(loss)
    # plt.show()
    a, b, c = Solutin().gradient_f(0)
    print(f'''
    a \t= {a}
    b \t= {b} 
    f(a, b) = {(a - 3) ** 2 + (b + 4) ** 2}
    count \t= {c}''')
    #梯度下降求梯度下降解反三角函数
    print(f'''sin({Solutin().arcsin(0.5)}) ≈ 0.5
    sin({Solutin().arcsin(math.sqrt(3) / 2)}) ≈ sqrt(3)/2
    ''')