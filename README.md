# nahida的java学习

## Java 关键词表

| #    | 关键词                  | 一句话定义                               | 易错点 / 与 C/C++ 差异                                  |
| ---- | ----------------------- | ---------------------------------------- | ------------------------------------------------------- |
| 1    | JVM                     | Java 虚拟机，字节码执行环境              | 跨平台的本质是"字节码 + JVM 抽象"，不是语言本身跨平台   |
| 2    | JDK / JRE / JVM         | JDK ⊃ JRE ⊃ JVM                          | 开发装 JDK，运行装 JRE；JDK 含 javac                    |
| 3    | 字节码 (.class)         | javac 编译产物，JVM 执行                 | 不是机器码，需 JVM 解释/JIT                             |
| 4    | `main` 方法签名         | `public static void main(String[] args)` | 参数名约定 `args` 非 `argv`；`public`/`static` 缺一不可 |
| 5    | 类名规范                | 大驼峰 `Demo1`                           | 文件名必须与 public 类名一致（含大小写）                |
| 6    | 方法名规范              | 小驼峰 `addAll`                          | C 风格 `Add`/`Fact` 会被 review 打回                    |
| 7    | 字符串拼接              | `"x" + 1 + 2` → `"x12"`                  | 左结合，遇 String 后全转字符串                          |
| 8    | char 算术               | `1 + 2 + 'x'` → `123`                    | char 参与算术提升为 int（UTF-16 码元值）                |
| 9    | char 底层               | UTF-16 码元，16 位                       | 与 C 的 ASCII/单字节不同；增补字符占两个 char           |
| 10   | 短路运算符              | `&&` `||` 左侧定值则不评右侧             | 副作用（`b++`）可验证是否执行                           |
| 11   | 非短路运算符            | `&` `|` 两侧必评                         | 布尔场景少用，位运算场景另论                            |
| 12   | if 条件类型             | 必须是 boolean                           | 不能像 C 用 `if(n)`，编译失败                           |
| 13   | switch 贯穿             | 传统 `case` 无 break 会贯穿              | 箭头 `->` 语法不贯穿；`case 1,2,3 ->` 合并              |
| 14   | switch 箭头语法         | `case X -> 语句`                         | JDK 14+；不会 fall-through                              |
| 15   | 块作用域                | `{}` 内变量外部不可见                    | 与 C 一致；但 Java 不允许同块重复定义                   |
| 16   | 增强 for                | `for (int v : arr)`                      | 只读遍历；改 `v` 不影响数组                             |
| 17   | 数组声明                | `int[] a` 或 `int a[]`                   | 推荐前者；`new int[3]` 默认 0                           |
| 18   | 数组是对象              | `arr.length` 是字段非方法                | `println(arr)` 打印 `[I@hash`，需 `Arrays.toString`     |
| 19   | 二维数组本质            | 数组的数组，可不规则                     | `t[0].length != t[1].length` 合法                       |
| 20   | `Arrays.toString`       | 一维数组转可读字符串                     | 二维需 `Arrays.deepToString`                            |
| 21   | `Arrays.sort`           | 原地升序排序                             | 基本类型用双轴快排，对象用 TimSort                      |
| 22   | `Arrays.binarySearch`   | 二分查找，返回下标                       | **必须先排序**，否则结果未定义                          |
| 23   | `Arrays.fill`           | 原地填充同一值                           | 会破坏源数据，演示时用独立数组                          |
| 24   | `Arrays.copyOf`         | 拷贝并可扩容，尾部补默认值               | 长度大于原数组时补 0/null                               |
| 25   | `Arrays.copyOfRange`    | 拷贝 `[from, to)` 左闭右开               | 注意 to 不含；源被 fill 后示例失真                      |
| 26   | `clone()`               | 浅拷贝数组                               | 对象数组只复制引用                                      |
| 27   | 方法重载                | 同名不同参（类型/个数/顺序）             | 返回值不同不算重载                                      |
| 28   | 重载决议                | 精确匹配 > 拓宽 > 装箱 > 可变参数        | `(1, 1.0)` 选 `(int,double)`                            |
| 29   | 可变参数                | `int... nums` 本质是数组                 | 只能放参数列表最后；可传数组                            |
| 30   | 递归                    | 方法自调用，需 base case                 | `Fact(13)` 起 int 溢出，用 long/BigInteger              |
| 31   | int 溢出                | 超过 2^31-1 回绕                         | 13! = 6227020800 已溢出                                 |
| 32   | Scanner                 | 文本输入解析                             | `nextInt()` 不消费换行，紧跟 `nextLine()` 读空串        |
| 33   | `nextInt`/`nextLine` 坑 | 前者留换行符在缓冲区                     | 修复：多读一次 `nextLine()` 或全用 `nextLine` 再 parse  |
| 34   | `nextDouble(bound)`     | 返回 `[0.0, bound)`                      | 不是保留两位小数                                        |
| 35   | `printf` + Locale       | `System.out.printf(Locale.US, ...)`      | 控制小数点是 `.` 还是 `,`                               |
| 36   | Random 种子             | `new Random(67)` 固定序列可复现          | 生产勿用固定种子，可预测                                |
| 37   | 命名规约                | 类大驼峰、方法/变量小驼峰、常量全大写    | 阿里规约硬性条款                                        |
| 38   | K&R 大括号风格          | `{` 与语句同行                           | Java 社区约定，C 风格另起行不推荐                       |

## 每日学习日志

### 2026-11-11 Java 基础语法（一）：运算、流程控制、数组与方法

1. 完成 `Demo1.java` 单文件笔记，覆盖 10 个语法点：算术与字符串拼接、短路/非短路运算符、if、switch（传统 + 箭头 + 多 case）、块作用域、for/while/do-while、数组（一维/二维/不规则/工具类）、方法重载、可变参数、Scanner/printf/Random。
2. 重点对照 **C 转 Java 的差异**：`if` 条件必须 boolean（不能 `if(n)`）；`char` 参与算术提升为 int（`1+2+'x'=123`），而 String 参与 `+` 触发拼接（`"x"+1+2="x12"`）；数组是对象、`length` 是字段、`println` 打印地址需 `Arrays.toString`。
3. 掌握 `Arrays` 工具类：`toString / sort / binarySearch（需先排序）/ fill / copyOf / copyOfRange（左闭右开）/ clone（浅拷贝）`。
4. 掌握 `switch` 三种写法：传统带 break、箭头 `->` 不贯穿、`case 1,2,3 ->` 合并；明确传统写法**故意不写 break 是反例**。
5. 方法特性：重载决议（精确 > 拓宽 > 装箱 > 可变参数）、可变参数本质是数组、递归阶乘的 int 溢出边界（13! 起溢出）。
6. **已知问题与改进方向**：
   - 命名全部违反 Java 规约：类名 `demo1`→`Demo1`、`main(String[] argv)`→`args`、方法 `Add/Say/Function1/Fact/AddAll`→小驼峰，且 `function1` 无表意需重命名。
   - `switch(nahida1)` 贯穿段是反例但未标注，复习会误读为正确写法。
   - `Arrays.fill` 先破坏 `arr4`，导致后续 `copyOfRange(arr4,1,2)` 示例失真，应改用独立源数组。
   - `Fact` 用 int 返回，需补 13! 溢出说明或改 long。
   - 缺 Scanner `nextInt`→`nextLine` 换行陷阱（Java 输入第一大坑）未记录。
   - `nextDouble(2.0)` 语义（`[0,bound)` 非保留两位）未注释；`Random(67)` 固定种子未说明可预测性。
   - 待补：String 常用 API、包装类自动装箱、重载决议三例、`int` 溢出与 `Integer.MAX_VALUE`。

## 🏆 核心里程碑回顾

1.**2026-11-11 Java 基础语法（一）**：完成首个 Java 笔记 `Demo1.java`，覆盖运算/流程控制/数组/方法/输入输出五大块；建立"C→Java 差异对照"笔记范式（boolean 条件、char 提升、String 拼接、数组即对象、Arrays 工具类、switch 箭头语法、重载决议、可变参数、Scanner 换行坑）；明确命名规约（类大驼峰/方法小驼峰/args）与 K&R 大括号风格为后续所有 Java 代码的硬约束。