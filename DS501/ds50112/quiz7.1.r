
# Your solutions to the question should be in the space provided.  Do not delete any of the lines provided.
# Your solution should include all necessary R code including print statements.  I am more interested in
# your method than your answer.   I will change some of the numbers in the data file before I run your
# program.

# Problem 1

options(StringsAsFactors=FALSE)
df <- read.csv("/u1/junk/cs459/quiz7.csv")
print("Problem 1")
nrow(df[df$outcome == "W",])


# Problem 2  -- note how the function was printed.
print("Problem 2")
nrow(df[df$alice > 20,]) 


# Problem 3  -- reading the data frame
print("Problem 3")
wcount <- 0
wstreak <- 0
for(i in df$outcome){
	if(i == "W"){
		wcount <- wcount + 1
	}
	if(i == "L"){
		if(wcount > wstreak){
			wstreak <- wcount
		}
		wcount <- 0
	}
}
print(wstreak)

# Problem 4  -- put your solution to problem 4 after the print statement.
print("Problem 4")
max(rowSums(df[,3:11]))




# Problem 5  -- put your solution to problem 5 after the print statement.

tb <- table(df$opponent,df$outcome)
tb <- tb[,c(2,1)] 
print(tb)

# Problem 6  -- put your solution to problem 6 after the print statement.
print("Problem 6")
#gamepoints[83,] <- lapply(gamepoints,FUN=ave,na.rm=FALSEI
pave <- round(colMeans(df[,3:11]),digits = 2)
print(pave)
# Problem 7  -- put your solution to problem 6 after the print statement.
print("Problem 7")
for(i in 1:20){ 
	maxpt <- max(df[i,3:11])
	print(maxpt)
}
# Problem 8  -- put your solution to problem 6 after the print statement.
print("Problem 8")
for(i in 1:20){
	print(df$alice/rowSums([i,3:11]))
}

#make a new df that has the opponent and alice's percentage

# Problem 9  -- put your solution to problem 9 after the print statement.

#
# This one makes the plot. Save it in a file named question9.pdf.
#

print("Problem 9")

