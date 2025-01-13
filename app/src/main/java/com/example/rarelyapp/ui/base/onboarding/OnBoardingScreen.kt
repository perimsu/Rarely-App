package com.example.rarelyapp.ui.base.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rarelyapp.R

// Karşılama ekranı, kullanıcının uygulamayı başlatması için bir mesaj ve buton içerir.
@Composable
fun WelcomeScreen(onStartClicked: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize(), // Ekranı tamamen doldurur
        contentAlignment = Alignment.Center // İçeriği merkezde hizalar
    ) {
        // Arka plan resmi
        Image(
            painter = painterResource(id = R.drawable.background_blue),
            contentDescription = null, // Açıklama eklenmedi
            modifier = Modifier.fillMaxSize(), // Resim ekranı tamamen kaplar
            contentScale = ContentScale.Crop // Resim ekrana orantılı şekilde kırpılır
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally // İçeriği yatayda merkezler
        ) {
            Spacer(modifier = Modifier.height(64.dp)) // Yukarıdan boşluk bırakır
            Text(
                modifier = Modifier.weight(2f), // Yükseklik boşluğunu esnek şekilde doldurur
                text = "WELCOME TO\nRARELY", // Başlık
                fontSize = 28.sp, // Yazı boyutu
                style = MaterialTheme.typography.titleLarge, // Temanın başlık yazı tipi
                color = Color.White, // Yazı rengi
                textAlign = TextAlign.Center // Metni ortalar
            )
            Column(
                modifier = Modifier.weight(2f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Your Journey Begins!", // Alt başlık
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    fontSize = 21.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(36.dp)) // Alt başlık ve buton arasında boşluk
                Button(
                    onClick = onStartClicked, // Buton tıklanınca verilen işlev çağrılır
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFC2C2C2) // Buton arka plan rengi
                    ),
                    modifier = Modifier.padding(16.dp) // Buton kenar boşlukları
                ) {
                    Text(text = "Get Started", color = Color(0xFF18233D)) // Buton metni
                }

            }
        }
    }
}

// Onboarding ekranını yöneten bileşen
@Composable
fun OnboardingScreen() {
    var showWelcomeScreen by remember { mutableStateOf(true) } // Başlangıç ekranı mı, onboarding mi kontrol eder

    if (showWelcomeScreen) {
        // Başlangıç ekranını gösterir
        WelcomeScreen(onStartClicked = { showWelcomeScreen = false }) // Tıklanınca onboarding ekranına geçer
    } else {
        val pages = listOf(
            // Onboarding sayfaları
            OnboardingPage(
                title = "WELCOME TO RARELY",
                description = "Explore, buy, and sell exclusive designer pieces and rare collectibles. From timeless bags to unique artworks, Rarely ensures authenticity and elegance at every step.",
                imageRes = R.drawable.onboard_2,
                backgroundImageRes = R.drawable.authentication_flow_background,
                textColor = Color(0xFF18233D)
            ),
            OnboardingPage(
                title = "AUTHENTICITY VERIFICATION",
                description = "We ensure the true value of luxury through rigorous authenticity checks by our expert team before listing any product. Every purchase also comes with certified verification for complete peace of mind.",
                imageRes = R.drawable.onboard_3,
                backgroundImageRes = R.drawable.background_blue,
                textColor = Color(0xFFC2C2C2)
            ),
            OnboardingPage(
                title = "AUCTION",
                description = "Join exclusive auctions to acquire one-of-a-kind pieces or showcase your own exceptional items, inviting competitive bids and maximizing the value of your collection.",
                imageRes = R.drawable.onboard_4,
                backgroundImageRes = R.drawable.authentication_flow_background,
                textColor = Color(0xFF18233D)
            )
        )

        val pagerState = rememberPagerState(initialPage = 0, pageCount = { pages.size }) // Pager durumu

        Column(
            modifier = Modifier.fillMaxSize()
                .padding(bottom = 56.dp) // Alt boşluk
        ) {
            Box {
                // Yatay kaydırılabilir onboarding sayfaları
                HorizontalPager(
                    state = pagerState
                ) { page ->
                    OnboardingPageContent(page = pages[page]) // Her sayfa içeriği
                }

                Spacer(modifier = Modifier.height(32.dp)) // Yukarı boşluk

                // Dots göstergesi ve buton
                Row(
                    modifier = Modifier
                        .fillMaxWidth() // Ekranın tamamını kaplar
                        .padding(horizontal = 24.dp) // Yatay boşluk
                        .align(Alignment.BottomCenter), // Alt merkeze hizalar
                    horizontalArrangement = Arrangement.SpaceBetween, // Elemanları iki uçta hizalar
                    verticalAlignment = Alignment.CenterVertically // Elemanları dikeyde ortalar
                ) {
                    // Dots göstergesi
                    DotsIndicator(
                        totalDots = pages.size,
                        selectedIndex = pagerState.currentPage,
                        color = pages[pagerState.currentPage].textColor
                    )
                    Button(
                        onClick = {
                            if (pagerState.currentPage == pages.lastIndex) {
                                /* Handle Get Started */
                            } else {
                                /* Handle Skip */
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = pages[pagerState.currentPage].textColor // Buton rengi
                        )
                    ) {
                        Text(
                            text = if (pagerState.currentPage == pages.lastIndex) "Get Started" else "Skip",
                            color = Color.White
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

// Onboarding sayfası içeriği
@Composable
fun OnboardingPageContent(page: OnboardingPage) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center // Merkeze hizalar
    ) {
        // Arka plan resmi
        Image(
            painter = painterResource(id = page.backgroundImageRes),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(36.dp))
            Text(
                text = page.title, // Başlık
                style = MaterialTheme.typography.titleLarge,
                color = page.textColor,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = page.description, // Açıklama
                style = MaterialTheme.typography.bodyLarge,
                color = page.textColor,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Image(
                painter = painterResource(id = page.imageRes), // Görsel
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )
        }
    }
}

// Sayfalar arası geçiş için Dots göstergesi
@Composable
fun DotsIndicator(totalDots: Int, selectedIndex: Int, color: Color) {
    Row(horizontalArrangement = Arrangement.Center) {
        for (i in 0 until totalDots) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .size(if (i == selectedIndex) 10.dp else 8.dp) // Seçili nokta büyük
                    .clip(CircleShape)
                    .background(
                        if (i == selectedIndex) color else color.copy(alpha = 0.4f) // Şeffaf renk
                    )
            )
        }
    }
}

// Onboarding sayfa modeli
data class OnboardingPage(
    val title: String,
    val description: String,
    val imageRes: Int,
    val backgroundImageRes: Int,
    val textColor: Color
)

// Onboarding ekranı önizlemesi
@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen()
}