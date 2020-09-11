
toMinutes <- function(s)
{
   s <- as.character(s)
   rv <- 0
   if(grepl('+', s, fixed=TRUE)){
     t <- strsplit(s,'+',fixed=TRUE)
     rv <- 60*24*as.integer(t[[1]][1])
     s <- t[[1]][2]
   }
   t <- strsplit(s,':',fixed=TRUE)
   rv = rv + 60 * as.integer(t[[1]][1]) + as.integer(t[[1]][2])
   return (rv)
}
