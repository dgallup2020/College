<?php 
//if the get variable doesn't exist, we want the normal page
if(!isset($_GET['q'])){

echo <<<END
 <!DOCTYPE html>
<html>
<head>
  <meta name="generator" content=
  "HTML Tidy for HTML5 for Linux version 5.3.9">
<script>
  function showRSS(str) {
  //empty string handling
          if (str.length==0) { 
                      document.getElementById("rssOutput").innerHTML="";
                          return;
	  }
      
          if (window.XMLHttpRequest) {
                  // code for IE7+, Firefox, Chrome, Opera, Safari
                  xmlhttp=new XMLHttpRequest();
          } else {  // code for IE6, IE5
                  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }

        //event listener//
	  xmlhttp.onreadystatechange=function() {
                   //if the stage is now 4 and status is okay
		  if (this.readyState==4 && this.status==200) {
                   //get the retruned info and put it on the screen
                          document.getElementById("rssOutput").innerHTML=this.responseText;
                  }
	  }
	 /////

         //make the request
	  xmlhttp.open("GET","rss.php?q="+str,true);
         //send it (the event listener will wait for a response response)
          xmlhttp.send();
  }

  </script>
  <title></title>
</head>
<body>
XAviers example here
  <form>
     <!--on change, update our xmlhttp request!-->
    <select onchange="showRSS(this.value)">
      <option value="">
        Select an RSS-feed:
      </option>
      <option value="Google">
        Google News
      </option>
      <option value="NBC">
        NBC News
      </option>
    </select>
  </form><br>
   <!-- the event listener gets this div and puts rss here !-->
  <div id="rssOutput">
    RSS-feed will be listed here...
  </div>
</body>
</html>
END;
//if the get variable exists, we need to output the rss intepritation
}else{
  //get the q parameter from URL
  $q=$_GET["q"];

  //find out which feed was selected
  if($q=="Google") {
	  $xml=("http://www.myanimelist.net/rss.php?type=rw&u=Dylan_Gallup");
    } elseif($q=="NBC") {
      $xml=("http://rss.msnbc.msn.com/id/3032091/device/rss/rss.xml");
      }

  //creat a new document
  $xmlDoc = new DOMDocument();


  //fill that document with the info found at url above
      $xmlDoc->load($xml);

  //from that document, grab the elements that interest you
  
  //get elements from "<channel>"
      $channel=$xmlDoc->getElementsByTagName('channel')->item(0);
      
         $channel_title = $channel->getElementsByTagName('title')
         ->item(0)->childNodes->item(0)->nodeValue;
      
         $channel_link = $channel->getElementsByTagName('link')
         ->item(0)->childNodes->item(0)->nodeValue;
      
         $channel_desc = $channel->getElementsByTagName('description')
         ->item(0)->childNodes->item(0)->nodeValue;

   //output elements from "<channel>"
      echo("<p><a href='" . $channel_link
        . "'>" . $channel_title . "</a>");
        echo("<br>");
        echo($channel_desc . "</p>");

        //get and output "<item>" elements
        $x=$xmlDoc->getElementsByTagName('item');
        for ($i=0; $i<=2; $i++) {
          $item_title=$x->item($i)->getElementsByTagName('title')
            ->item(0)->childNodes->item(0)->nodeValue;
              $item_link=$x->item($i)->getElementsByTagName('link')
                ->item(0)->childNodes->item(0)->nodeValue;
                  $item_desc=$x->item($i)->getElementsByTagName('description')
                    ->item(0)->childNodes->item(0)->nodeValue;
                      echo ("<p><a href='" . $item_link
                              . "'>" . $item_title . "</a>");
                          echo ("<br>");
                            echo ($item_desc . "</p>");
	}
}
?>

