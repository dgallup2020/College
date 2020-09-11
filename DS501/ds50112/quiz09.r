timeconv <- function(x){
#case where there is more than a day's worth

#case where grepl finds a + or not change the way to read
if(grepl("\\+",x)){	
z <- strsplit(x,"\\+")[[1]]	
days <- as.numeric(z[1])	
y <- strsplit(z[2],":")[[1]]

hr <- as.numeric(y[1])
min <- as.numeric(y[2])
total <- days*24 + hr + min/60
}

else{
y <- strsplit(x,":")[[1]]
hr <- as.numeric(y[1])
min <- as.numeric(y[2])
total <- hr + min/60
}

return(round(total,digits = 2))
}

#Run code in Rscript command, have a modified last output called 
#april19last.csv in my home dir which is uploaded

#start of code
print("DS501: QUIZ09")
print("Dylan Gallup")
options(StringAsFactors=FALSE)
last <- read.csv("/u1/class/ds50112/april19last.csv")
names(last) <- c("user","day","month","time_in")
last$hours <- unlist(lapply(as.character(last$time_in),timeconv))
head(last)

#user's number of logins and hours logged in
print("user's logins-----")
agg <- aggregate(last$user,list(logins=last$user),length)
agg2 <- aggregate(last$hours,list(logins=last$user),sum)
agg[,3] <- agg2[,2]
names(agg) <- c("user","logins","totalhours")
print(agg)

#agg by class for number of logins and hours
print("class' logins-----")
temp <- last[grep("^(cs|ds)",last$user),]
temp$user <- unlist(lapply(temp$user,function(x) return(substr(x,1,5))))
agg <- aggregate(temp$user,list(logins=temp$user),length)
agg2 <- aggregate(temp$hours,list(logins=temp$user),sum)
agg[,3] <- agg2[,2]
names(agg) <- c("class","logins","totalhours")
print(agg)


#agg by month for number of logins and hours
print("monthly logins-----")
agg <- aggregate(last$month,list(logins=last$month),length)
agg2 <- aggregate(last$hours,list(logins=last$month),sum)
agg[,3] = agg2[,2]
names(agg) <- c("month","logins","totalhours")
print(agg)

#agg by day of the week number of logins and hours
print("daily logins-----")
agg <- aggregate(last$day,list(logins=last$day),length)
agg2 <- aggregate(last$hours,list(logins=last$day),sum)
agg[,3] <- agg2[,2]
names(agg) <- c("day","logins","totalhours")
print(agg)

#agg by the hours, number of logins and total it. 
print("hourly logins-----")
agg <- aggregate(last$hours,list(logins=last$hours),length)
agg2 <- aggregate(last$hours,list(logins=last$hours),sum)
agg[,3] <- agg2[,2]
names(agg) <- c("hours_spent","logins","totalhours")
print(agg)

