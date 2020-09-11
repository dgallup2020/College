
#
# Your solutions to the question should be in the space provided.  Do not delete any of the lines provided.
# Your solution should include all necessary R code including I/O.
#
# The data files are in "/u1/junk/cs459/quiz08.csv" and "/u1/junk/cs459/credits08.csv".
#
college<-read.csv("/u1/junk/cs459/quiz08.csv")
credits<-scan("/u1/junk/cs459/credits08.csv",sep=",")

# Problem 1  -- put your solution to problem 4 after the print statement. 
print("Problem 1")
print(nrow(college[college$state=='IN',]))

# Problem 2  -- put your solution to problem 4 after the print statement. 
print("Problem 2")
print(nrow(college[college$state=='IN' & college$city=='Greenville',]))

# Problem 3  -- put your solution to problem 4 after the print statement.
print("Problem 3")
agg <- aggregate(college$first,list(college$state),length)
names(agg) <- c("State","Count")
agg <- agg[order(agg$Count,decreasing=T),]
print(agg)


# Problem 4  -- put your solution to problem 4 after the print statement.
print("Problem 4")
agg <- aggregate(college$city,list(college$city,college$state),length)
names(agg) <- c("City","State","Count")
agg <- agg[order(agg$Count,decreasing=T),]
print(agg)


# Problem 5  -- put your solution to problem 5 after the print statement.
print("Problem 5")
engfun <- function(x){if(any(x == 0)){return(1)} else return(0)}
print(sum(apply(college[,16:19],1,engfun)))


# Problem 6  -- put your solution to problem 6 after the print statement.
print("Problem 6")
print(sum(apply(college[,7:19],1,engfun)))

# Problem 7  -- put your solution to problem 6 after the print statement.
print("Problem 7")
x <- sweep(college[,7:19],MARGIN=2,0,FUN=function(x,y) ifelse(x!=0,1,0))
college$credits <- apply(sweep(x,MARGIN=2,credits,FUN="*"),1,sum)
print(mean(college$credits))

# Problem 8  -- put your solution to problem 6 after the print statement.
print("Problem 8")
college$gpa <- apply(sweep(college[,7:19],MARGIN=2,credits,FUN="*"),1,sum)/college$credits
print(mean(college$gpa))
print(max(college$gpa))
print(min(college$gpa))
# Problem 9  -- put your solution to problem 9 after the print statement.
print("Problem 9")
ag <- aggregate(college$gpa,list(college$dorm),mean)
names(ag) <- c("Dorm","MeanGPA")
dormgpa <- ag[order(ag$MeanGPA,decreasing=T),]
print(dormgpa[1,])

# Problem 10  -- put your solution to problem 10 after the print statement.
print("Problem 10")

agg <- aggregate(college$gpa,list(college$city,college$state),mean)
names(agg) <- c("City","State","MeanGPA")
citygpa <- agg[order(agg$MeanGPA,decreasing=T),]
print(citygpa[1,])

# Problem 11  -- put your solution to problem 11 after the print statement.
print("Problem 11")
print(cor(college$cs151,college$cs475))



# Problem 12  -- put your solution to problem 12 after the print statement.
print("Problem 12")
print(lm(college$cs475 ~ college$cs151))

# Problem 13  -- put your solution to problem 13 after the print statement.
print("Problem 13")
#wilcox.test(college[,12:15],college[,16:19])
mathd <- unlist(college[,12:15])
engd <- unlist(college[,16:19])
wilcox.test(engd, mathd)
print("since the p-value is greater than our significance level so, we can assume they are the same population")

