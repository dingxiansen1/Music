import kotlinx.serialization.Serializable

data class HomePage(
    var blockCodeOrderList: Any,
    var blockUUIDs: Any,
    var blocks: List<Block>,
    var cursor: String? = "",
    var demote: Boolean,
    var exposedResource: String? = "",
    var guideToast: GuideToast,
    var hasMore: Boolean,
    var internalTest: String? = "",
    var pageConfig: PageConfig,
    var titles:List<String>? = emptyList()
)

@Serializable
data class Block(
    var action: String? = "",
    var actionType: String? = "",
    var alg: String? = "",
    var blockCode: String? = "",
    var blockStyle: Int,
    var canClose: Boolean,
    var canFeedback: Boolean,
    var creatives: List<Creative>? = emptyList(),
    var dislikeShowType: Int,
    var extInfo: String? = "",
    var logInfo: String? = "",
    var resourceIdList: List<String>? = emptyList(),
    var showType: String? = "",
    var uiElement: UiElementXX?=null
)

@Serializable
data class ExtInfo(
    var banners: List<Banner>? = emptyList(),
)

@Serializable
data class Banner(
    var alg: String? = "",
    var bannerBizType: String? = "",
    var bannerId: String? = "",
    var encodeId: String? = "",
    var exclusive: Boolean,
    var pic: String = "",
    var requestId: String? = "",
    var s_ctrp: String? = "",
    var scm: String? = "",
    var showAdTag: Boolean,
    var targetId: Long,
    var targetType: Int,
    var titleColor: String? = "",
    var typeTitle: String = "",
    var url: String? = "",
    var video: String? = ""
)

data class GuideToast(
    var hasGuideToast: Boolean,
    var toastList: List<String>? = emptyList()
)

data class PageConfig(
    var abtest: List<String>? = emptyList(),
    var fullscreen: Boolean,
    var homepageMode: String? = "",
    var nodataToast: String? = "",
    var orderInfo: String? = "",
    var refreshIntervar: Int,
    var refreshToast: String? = "",
    var showModeEntry: Boolean,
    var songLabelMarkLimit: Int,
    var songLabelMarkPriority: List<String>? = emptyList(),
    var title: Any
)

@Serializable
data class Creative(
    var action: String? = "",
    var actionType: String? = "",
    var alg: String? = "",
    var creativeId: String? = "",
    var creativeType: String? = "",
    var logInfo: String? = "",
    var position: Int,
    var resources: List<Resource>? = emptyList(),
    var uiElement: UiElementX?
)


@Serializable
data class UiElementXX(
    var button: Button?,
    var rcmdShowType: String? = "",
    var subTitle: SubTitleX?
)

@Serializable
data class Resource(
    var action: String? = "",
    var actionType: String? = "",
    var alg: String? = "",
    var ctrp: String? = "",
    var likedCount: String? = "",
    var logInfo: String? = "",
    var replyCount: String? = "",
    var resourceContentList: String? = "",
    var resourceExtInfo: ResourceExtInfo,
    var resourceId: String? = "",
    var resourceState: String? = "",
    var resourceType: String? = "",
    var resourceUrl: String? = "",
    var uiElement: UiElement,
    var varid: Boolean
)

@Serializable
data class UiElementX(
    var image: ImageX?,
    var labelTexts: List<String>? = emptyList(),
    var mainTitle: MainTitleX?,
    var rcmdShowType: String? = ""
)

@Serializable
data class ResourceExtInfo(
    var artists: List<Artist>? = emptyList(),
    var highQuality: Boolean,
    var playCount: Int,
    var specialType: Int
)

@Serializable
data class UiElement(
    var image: Image?,
    var labelTexts: List<String>? = emptyList(),
    var mainTitle: MainTitle?,
    var rcmdShowType: String? = "",
    var subTitle: SubTitle?
)

@Serializable
data class Artist(
    var albumSize: Int,
    var alias: List<String>? = emptyList(),
    var briefDesc: String? = "",
    var id: Int,
    var img1v1Id: Int,
    var img1v1Url: String? = "",
    var musicSize: Int,
    var name: String? = "",
    var picId: Int,
    var picUrl: String? = "",
    var topicPerson: Int,
    var trans: String? = ""
)

@Serializable
data class Image(
    var imageUrl: String? = ""
)

@Serializable
data class MainTitle(
    var title: String = ""
)

@Serializable
data class SubTitle(
    var title: String? = "",
    var titleId: String? = "",
    var titleType: String? = ""
)

@Serializable
data class ImageX(
    var imageUrl: String? = ""
)

@Serializable
data class MainTitleX(
    var title: String? = ""
)

@Serializable
data class Button(
    var action: String? = "",
    var actionType: String? = "",
    var biData: String? = "",
    var iconUrl: String? = "",
    var text: String? = ""
)

@Serializable
data class SubTitleX(
    var title: String = ""
)