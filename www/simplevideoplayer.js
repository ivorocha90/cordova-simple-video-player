var simpleVideoPlayer = {
    play: function(sourceUrl, showControls, successCallback, failCallback){
        cordova.exec(successCallback, failCallback, "SimpleVideoPlayer", "play", [sourceUrl, showControls]);
    }
};
module.exports = simpleVideoPlayer;

