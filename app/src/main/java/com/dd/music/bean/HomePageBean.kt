
data class HomePage(
    val blockCodeOrderList: Any,
    val blockUUIDs: Any,
    val blocks: List<Block>,
    val cursor: String,
    val demote: Boolean,
    val exposedResource: String,
    val guideToast: GuideToast,
    val hasMore: Boolean,
    val internalTest: Any,
    val pageConfig: PageConfig,
    val titles: List<Any>
)

data class Trp(
    val rules: List<String>
)

data class Block(
    val action: String,
    val actionType: String,
    val alg: String,
    val blockCode: String,
    val blockStyle: Int,
    val canClose: Boolean,
    val canFeedback: Boolean,
    val creatives: List<Creative>,
    val dislikeShowType: Int,
    val extInfo: ExtInfo?,
    val logInfo: String,
    val resourceIdList: List<String>,
    val showType: String,
    val uiElement: UiElementXX
)

data class GuideToast(
    val hasGuideToast: Boolean,
    val toastList: List<Any>
)

data class PageConfig(
    val abtest: List<String>,
    val fullscreen: Boolean,
    val homepageMode: String,
    val nodataToast: String,
    val orderInfo: String,
    val refreshInterval: Int,
    val refreshToast: String,
    val showModeEntry: Boolean,
    val songLabelMarkLimit: Int,
    val songLabelMarkPriority: List<String>,
    val title: Any
)

data class Creative(
    val action: String,
    val actionType: String,
    val alg: String,
    val creativeId: String,
    val creativeType: String,
    val logInfo: String,
    val position: Int,
    val resources: List<Resource>,
    val uiElement: UiElementX
)

data class ExtInfo(
    val banners: List<Banner>
)

data class UiElementXX(
    val button: Button,
    val rcmdShowType: String,
    val subTitle: SubTitleX
)

data class Resource(
    val action: String,
    val actionType: String,
    val alg: String,
    val ctrp: Any,
    val likedCount: Any,
    val logInfo: String,
    val replyCount: Any,
    val resourceContentList: Any,
    val resourceExtInfo: ResourceExtInfo,
    val resourceId: String,
    val resourceState: Any,
    val resourceType: String,
    val resourceUrl: Any,
    val uiElement: UiElement,
    val valid: Boolean
)

data class UiElementX(
    val image: ImageX,
    val labelTexts: List<String>,
    val mainTitle: MainTitleX,
    val rcmdShowType: String
)

data class ResourceExtInfo(
    val artists: List<Artist>,
    val highQuality: Boolean,
    val playCount: Int,
    val specialType: Int
)

data class UiElement(
    val image: Image,
    val labelTexts: List<String>,
    val mainTitle: MainTitle,
    val rcmdShowType: String,
    val subTitle: SubTitle
)

data class Artist(
    val albumSize: Int,
    val alias: List<Any>,
    val briefDesc: String,
    val id: Int,
    val img1v1Id: Int,
    val img1v1Url: String,
    val musicSize: Int,
    val name: String,
    val picId: Int,
    val picUrl: String,
    val topicPerson: Int,
    val trans: String
)

data class Image(
    val imageUrl: String
)

data class MainTitle(
    val title: String
)

data class SubTitle(
    val title: String,
    val titleId: String,
    val titleType: String
)

data class Banner(
    val alg: String,
    val bannerBizType: String,
    val bannerId: String,
    val encodeId: String,
    val exclusive: Boolean,
    val pic: String,
    val requestId: String,
    val s_ctrp: String,
    val scm: String,
    val showAdTag: Boolean,
    val showContext: Any,
    val targetId: Int,
    val targetType: Int,
    val titleColor: String,
    val typeTitle: String,
    val url: String,
    val video: String
)


data class ImageX(
    val imageUrl: String
)

data class MainTitleX(
    val title: String
)

data class Button(
    val action: String,
    val actionType: String,
    val biData: String,
    val iconUrl: String,
    val text: String
)

data class SubTitleX(
    val title: String
)