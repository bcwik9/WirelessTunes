var	iTunesApp = WScript.CreateObject("iTunes.Application");
var playing = 1;
if(iTunesApp.PlayerState != playing){
	iTunesApp.Play();
}