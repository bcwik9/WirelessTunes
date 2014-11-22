var	iTunesApp = WScript.CreateObject("iTunes.Application");
if(WScript.Arguments.length != 0){
	var newVol =Number(WScript.Arguments.Item(0));
	if(newVol >= 0 || newVol < 0){
		iTunesApp.SoundVolume = newVol;
	}
}