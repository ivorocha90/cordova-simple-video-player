cordova.define("com.irdev.cordova.simplevideoplayer.SimpleVideoPlayer", function(require, exports, module) { var simpleVideoPlayer = {
    play: function(sourceUrl, showControls, successCallback, failCallback){
        cordova.exec(successCallback, failCallback, "SimpleVideoPlayer", "play", [sourceUrl, showControls]);
    }
};
module.exports = simpleVideoPlayer;
});
