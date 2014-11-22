/*Ben Cwik
Call this file through cmd as such: play.js <search parameter>.  Example: play.js weezer
This file creates playlists identical to the iTunes search function and plays them
*/



//file i/o stuff, type out.WriteLine("text"); to output to output.txt
/*var fso, out;
fso = new ActiveXObject("Scripting.FileSystemObject");
out = fso.CreateTextFile ("output.txt",true);*/

//sort function to sort by playedcount
function sortByPlayedCount(a,b){
	if(a.PlayedCount > b.PlayedCount){
		return -1;
	}else if(a.PlayedCount < b.PlayedCount){
		return 1;
	}else{
		return 0;
	}
}

//TrackCollection c, returns track array
function trackCollectionToArray(c){
	var i = 1;
	var arr = new Array();
	while(i <= c.Count){
		arr[i-1]=c.Item(i);
		i++;
	}
	return arr;
}

//creates a playlist  based off an track array
function createPlaylist(a){
	var i = 0;
	var pl = iTunesApp.CreatePlaylist("WirelessTunes");
	while(i < a.length){
		curTrack = a[i];
		pl.AddFile(curTrack.Location);
		i++;
	}
	return pl;
}

//Main
var stopped = 0;
var args = WScript.Arguments;
var iTunesApp = WScript.CreateObject("iTunes.Application");
var mainLibrary = iTunesApp.LibraryPlaylist;
var playlists = iTunesApp.LibrarySource.Playlists;
if(!args.length == 0){
	var i = 1;
	var searchString = args.Item(0);
	//build the search term from args
	while(i < args.length){
		searchString = searchString + " " + args.Item(i);
		i++;
	}
	var trackCol = mainLibrary.Search(searchString,0);
	if(trackCol != null){
		var arr = trackCollectionToArray(trackCol);
		//delete the old WirelessTunes playlist so dont make duplicates
		var wt = playlists.ItemByName("WirelessTunes");
		while(wt != null){
			playlists.ItemByName("WirelessTunes").Delete();
			wt = playlists.ItemByName("WirelessTunes");
		}
		arr.sort(sortByPlayedCount);
		var tempnewlist = createPlaylist(arr);
		tempnewlist.PlayFirstTrack();
	}
} else {
	iTunesApp.Play();
}