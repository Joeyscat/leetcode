use sql_learning;

# 197.上升的温度
# 给定一个 Weather 表，编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 Id
create table Weather
(
    Id          int  not null,
    Temperature int  not null,
    RecordDate  date not null
);

insert into Weather(id, Temperature, RecordDate)
values (1, 10, '2015-01-01'),
       (2, 25, '2015-01-02'),
       (3, 20, '2015-01-03'),
       (4, 30, '2015-01-04');

select a.Id
from Weather as a
         join Weather as b
              on a.Temperature > b.Temperature
                  and dateDiff(a.RecordDate, b.RecordDate) = 1;


# 596. 超过5名学生的课
# 有一个courses 表 ，有: student (学生) 和 class (课程)。
# 请列出所有超过或等于5名学生的课。
# 例如,表:
#
# +---------+------------+
# | student | class      |
# +---------+------------+
# | A       | Math       |
# | B       | English    |
# | C       | Math       |
# | D       | Biology    |
# | E       | Math       |
# | F       | Computer   |
# | G       | Math       |
# | H       | Math       |
# | I       | Math       |
# +---------+------------+
#
# 应该输出:
#
# +---------+
# | class   |
# +---------+
# | Math    |
# +---------+
# Note:
# 学生在每个课中不应被重复计算
#
create table courses
(
    Id      int         not null,
    student varchar(50) not null,
    class   varchar(50) not null
);

insert into courses
    (student, class)
values ('A', 'Math')
     , ('B', 'English')
     , ('C', 'Math')
     , ('D', 'Biology')
     , ('E', 'Math')
     , ('F', 'Computer')
     , ('G', 'Math')
     , ('H', 'Math')
     , ('I', 'Math');

select *
from courses;
select class
from courses
group by class
having count(distinct student) >= 5;

# 176. 第二高的薪水
# 编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。
#
# +----+--------+
# | Id | Salary |
# +----+--------+
# | 1  | 100    |
# | 2  | 200    |
# | 3  | 300    |
# +----+--------+
# 例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。
#
# +---------------------+
# | SecondHighestSalary |
# +---------------------+
# | 200                 |
# +---------------------+

create table employee
(
    id     int not null,
    salary int not null
);

insert into employee
    (id, salary)
VALUES (1, 100),
       (2, 200),
       (3, 300);


SELECT (
           SELECT DISTINCT salary
           FROM employee
           ORDER BY salary DESC
           LIMIT 1 OFFSET 1
       ) AS SecondHighestSalary;

SELECT IFNULL(
               (SELECT DISTINCT Salary
                FROM employee
                ORDER BY Salary DESC
                LIMIT 1 OFFSET 1),
               NULL) AS SecondHighestSalary;

select max(Salary) as SecondHighestSalary
from employee
where Salary < (
    select max(Salary)
    from employee
);

# 626. 换座位
# 小美是一所中学的信息科技老师，她有一张 seat 座位表，平时用来储存学生名字和与他们相对应的座位 id。
# 其中纵列的 id 是连续递增的
# 小美想改变相邻俩学生的座位。
# 你能不能帮她写一个 SQL query 来输出小美想要的结果呢？
#
# 示例：
# +---------+---------+
# |    id   | student |
# +---------+---------+
# |    1    | Abbot   |
# |    2    | Doris   |
# |    3    | Emerson |
# |    4    | Green   |
# |    5    | Jeames  |
# +---------+---------+
# 假如数据输入的是上表，则输出结果如下：
# +---------+---------+
# |    id   | student |
# +---------+---------+
# |    1    | Doris   |
# |    2    | Abbot   |
# |    3    | Green   |
# |    4    | Emerson |
# |    5    | Jeames  |
# +---------+---------+
# 注意：
# 如果学生人数是奇数，则不需要改变最后一个同学的座位。
create table seat
(
    id      int         not null,
    student varchar(50) not null
);

insert into seat (id, student)
VALUES (1, 'Doris'),
       (2, 'Abbot'),
       (3, 'Green'),
       (4, 'Emerson'),
       (5, 'Jeames');

select if(id % 2 = 0, id - 1, if(id = (select count(distinct id) from seat), id, id + 1)) as id, student
from seat
order by id;






