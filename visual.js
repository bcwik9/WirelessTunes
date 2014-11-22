var iTunesApp = WScript.CreateObject("iTunes.Application");
iTunesApp.FullScreenVisuals = true;
iTunesApp.VisualsEnabled = !iTunesApp.VisualsEnabled;