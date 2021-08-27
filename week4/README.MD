
## Requestinfo Table

![image](https://user-images.githubusercontent.com/57210973/131138535-370d2238-6cd3-40af-ade6-f93b166a8472.png)


Requestinfo Table의 데이터입니다.

## User Table

![image](https://user-images.githubusercontent.com/57210973/131138642-be98d4cb-fb17-49de-932d-50c8921c829b.png)


User Table의 데이터입니다.


## daysOff Table

![image](https://user-images.githubusercontent.com/57210973/131138598-d87a4459-df6d-4697-b70a-f3a1f18a6ce2.png)


일정기간의 휴일(공휴일, 토요일 및 일요일)을 담은 테이블 daysOff table입니다.


## Example of an error response

![image](https://user-images.githubusercontent.com/57210973/131138666-37791a3e-17ae-4d8f-9321-ded7370e70ae.png)



## Example of a successful query for monthly logins
![image](https://user-images.githubusercontent.com/57210973/131138712-c7299a9e-def4-42db-902d-af8ced5f7124.png)


## Example of a successful query for daily logins
![image](https://user-images.githubusercontent.com/57210973/131138744-99a2040f-9cd1-4b29-8e04-147c23d74747.png)


## Example of a successful query for average logins per day
![image](https://user-images.githubusercontent.com/57210973/131138778-41e3f948-5451-4e25-94e8-7296595a1cb2.png)

<br/><br/>
평균 계산할 때 가장 처음으로 로그인한 날짜와 현재 날짜를 구한 후 모든 일의 수를 천체 로그인 수를 나누었습니다.


## Example of a successful query for number of logins on workdays
![image](https://user-images.githubusercontent.com/57210973/131138831-61b50384-3850-4a5c-8020-b8ced883700f.png)

<br/><br/>
daysOff table에 있는 데이터와 left join 후 남은 로그인 기록 수 입니다.


## Example of a successful query of logins for department and month
![image](https://user-images.githubusercontent.com/57210973/131138959-46ce8e2e-0220-49c3-bc24-2979ff44ddf3.png)


User 테이블와 조인하여 부서별 로그인 수 산출했습니다.



