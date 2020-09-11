#
# a plot I didn't finish in class
# to run it login, cd to /u1/junk/cs459/feb04, then run R
# and finally source('run.r')
# check out the values in the variables u and t

options(stringsAsFactors=FALSE)

# read the list, add names for each item, convert to df

li <- scan('data',what=list('','','','','','','',''))
names(li) <- c('user','ip','wday','mon','mday','in','out','rawtime')
df <- as.data.frame(li)

options(stringsAsFactors=TRUE)

# get login names that match the pattern for class accounts and
# save the first 5 chars of each

u <- substr(df$user[grep('^[dc]s[0-9][0-9][0-9]..$',df$user)],1,5)

# set background color

par(bg='wheat')

#set inner and outer margins -- mainly so there's enough room for vertical text (class names)

par(mar=c(3, 1, 1, 1))
par(oma=c(3,3,3,3))

# make a table from the class name list (count how often each name appears)
# then sort the table by frequency
#
# table uses the low level functions 'tabulate' and (if needed) 'as.factor'
# to do it's job.  run tabulate(as.factor(u)) and compare.
#

t <- sort(table(u),descreasing=TRUE)

# xaxt = 'n' turns off default x axis labels

b <- barplot(t,xaxt='n')

# set x coordinate for text to b, which contains a list of x coordinates for the barplot bars
# set y < 0 so there is room for the names under the plot
# names(t) is the list of class names (keys for the table)
# xpd = TRUE means it's ok to print outside of the inner margins
# srt = -90 means rotate the text 90 degrees counterclockwise

text(x=b,y=-30,names(t),xpd=TRUE,srt=90)
title('2019 CS login count by course')

